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
public class Lesson_10_Subjects_BehaviourSubject_Two_Subscribers {

    public static void main(String[] arg) throws InterruptedException{
        
            BehaviorSubject<String> subject = BehaviorSubject.createDefault("Start State");

            subject.subscribe(letter -> log.accept("Subcriber 1 "+letter));
            subject.subscribe(
                 letter -> log.accept("Subcriber 2 : "+letter),
                 e  -> subject.onError(e),
                 () -> log.accept("Subcriber 2 : onCompleted"));

             // Both Subscribers would parallely cosume all the events
            Observable.fromIterable(alphaLetters())
                    .subscribe(
                            (letter) -> subject.onNext(letter),
                             e -> subject.onError(e),
                            () -> subject.onComplete()
                    );
            
            
            
    }
}
