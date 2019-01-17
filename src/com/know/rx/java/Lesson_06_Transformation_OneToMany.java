package com.know.rx.java;

import com.know.util.Utils;
import io.reactivex.Observable;
import java.util.Arrays;

/**
 *
 * @author KnowGroup
 */
public class Lesson_06_Transformation_OneToMany {
    public static void main(String[] arg){
        Observable.fromIterable(Utils.greekLetters())
                .flatMap(letter -> Observable.fromIterable(Arrays.asList(letter.toUpperCase(),letter.toLowerCase())))
                .subscribe(l -> Utils.log.accept(l));
    }
}
