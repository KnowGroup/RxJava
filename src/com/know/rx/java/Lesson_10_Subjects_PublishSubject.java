package com.know.rx.java;

import io.reactivex.subjects.PublishSubject;
import static com.know.util.Utils.log;
import static com.know.util.Utils.alphaLetters;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
/**
 *
 * @author KnowGroup
 */
public class Lesson_10_Subjects_PublishSubject {

    public static void main(String[] arg) throws InterruptedException{
        Object signal = new Object();
        
        synchronized(signal){

            PublishSubject<String> subject = PublishSubject.create();
            
            //  subscriber to subject
            subject.subscribe(
                letter ->{
                    log.accept("Subcriber 1 "+letter);

                    Thread.currentThread().sleep(50);
                    if(letter.equals("Five")){
                      synchronized(signal){
                          signal.notify();
                      }   
                    }                        
                }
            );
            
            Observable.fromIterable(alphaLetters())
                    .subscribeOn(Schedulers.computation())
                    .subscribe(
                            (letter) -> subject.onNext(letter),
                            e -> subject.onError(e),
                            () -> {
                                log.accept("Subscriber 1: onCompleted");
                                subject.onComplete();
                                synchronized(signal){
                                    signal.notify();
                                }
                            });
            
            signal.wait();
            
            subject.subscribe(
                 letter -> log.accept("Subcriber 2 : "+letter),
                 e  -> subject.onError(e),
                 () -> log.accept("Subcriber 2 : onCompleted"));
            
            signal.wait();
        }
        
        System.exit(0);
    }
}
