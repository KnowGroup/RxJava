package com.know.rx.java;

import static com.know.util.Utils.log;
import static com.know.util.Utils.alphaLetters;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
/**
 *
 * @author KnowGroup
 */
public class Lesson_10_Subjects_BehaviourSubject_All_Events_Comsumed_First_Subscriber {

    public static void main(String[] arg) throws InterruptedException{
        
            BehaviorSubject<String> subject = BehaviorSubject.createDefault("Start State");

            subject.subscribe(letter -> log.accept("Subcriber 1 "+letter));
            
            Observable.fromIterable(alphaLetters())
                    .subscribe(
                            (letter) -> subject.onNext(letter),
                             e -> subject.onError(e),
                            () -> subject.onComplete()
                    );
            
            // All events are already been consumed by Subscriber 1
            subject.subscribe(
                 letter -> log.accept("Subcriber 2 : "+letter),
                 e  -> subject.onError(e),
                 () -> log.accept("Subcriber 2 : onCompleted"));
            
    }
}
