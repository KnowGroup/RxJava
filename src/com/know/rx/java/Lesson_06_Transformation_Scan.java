package com.know.rx.java;

import com.know.util.Utils;
import io.reactivex.Observable;

/**
 *
 * @author KnowGroup
 */
public class Lesson_06_Transformation_Scan {
    public static void main(String[] arg){
        Observable.fromIterable(Utils.greekLetters())
                .scan((letter1,letter2) -> letter1.concat(letter2))
                .subscribe(l -> Utils.log.accept(l));
        
        /*
            To avoid intermediate events on subscribe we should use last 
        */
        Utils.log.accept("To avoid intermediate events on subscribe we should use lastElement ");
        Observable.fromIterable(Utils.greekLetters())
                .scan((letter1,letter2) -> letter1.concat(letter2))
                .lastElement()
                .subscribe(l -> Utils.log.accept(l));
        
    }
}
