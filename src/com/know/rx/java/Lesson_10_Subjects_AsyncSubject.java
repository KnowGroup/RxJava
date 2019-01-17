package com.know.rx.java;

import static com.know.util.Utils.log;
import static com.know.util.Utils.alphaLetters;
import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;
/**
 *
 * @author KnowGroup
 */
public class Lesson_10_Subjects_AsyncSubject {

    public static void main(String[] arg) throws InterruptedException{
        
            AsyncSubject<String> subject = AsyncSubject.create();

            subject.subscribe(
                 letter -> log.accept("Subcriber : "+letter),
                 e  -> subject.onError(e),
                 () -> log.accept("Subcriber : onCompleted"));


             // Only Last state would be emit
            Observable.fromIterable(alphaLetters())
                    .subscribe(
                            (letter) -> subject.onNext(letter),
                             e -> subject.onError(e),
                            () -> subject.onComplete()
                    );

             subject
                 .scan((letter1,letter2) -> letter1 + " , "+ letter2)
                 .lastElement()
                 .subscribe(
                 letter -> log.accept("Subcriber 2 : "+letter),
                 e  -> subject.onError(e),
                 () -> log.accept("Subcriber : onCompleted"));

            Observable
                    .fromIterable(alphaLetters())
                    .subscribe(
                            (letter) -> subject.onNext(letter),
                             e -> subject.onError(e),
                            () -> subject.onComplete()
                    );
            
    }
}
