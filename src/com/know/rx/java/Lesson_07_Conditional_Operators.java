package com.know.rx.java;

import static com.know.util.Utils.fibonacciList;
import static com.know.util.Utils.greekLetters;
import static com.know.util.Utils.log;
import io.reactivex.Observable;

/**
 *
 * @author KnowGroup
 */
public class Lesson_07_Conditional_Operators {

    public static void main(String[] arg){
        
        TimeTicker timeTicker = new TimeTicker(3000);
        
        Observable.fromIterable(fibonacciList())
                .skipWhile(e -> e < 8)
                .subscribe(e -> log.accept("fromIterable :   "+e));
        
        Observable.fromIterable(fibonacciList())
                .takeWhile(e -> e < 8)
                .subscribe(e -> log.accept("takeWhile :   "+e));
        
        Observable.empty()
                .defaultIfEmpty("Empty Observable")
                .subscribe(e -> log.accept("defaultIfEmpty :   "+e));
        
        Observable.fromIterable(greekLetters())
                .defaultIfEmpty("Empty Observable")
                .firstElement()
                .subscribe(e -> log.accept("Non Empty defaultIfEmpty :   "+e));
        
    }
}