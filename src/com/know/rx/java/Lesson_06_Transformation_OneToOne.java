package com.know.rx.java;

import com.know.util.Utils;
import io.reactivex.Observable;

/**
 *
 * @author KnowGroup
 */
public class Lesson_06_Transformation_OneToOne {
    public static void main(String[] arg){
        Observable.fromIterable(Utils.greekLetters())
                .map(letter -> letter.toUpperCase())
                .subscribe(l -> Utils.log.accept(l));
    }
}
