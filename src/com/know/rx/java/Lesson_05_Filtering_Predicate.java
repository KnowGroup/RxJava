package com.know.rx.java;

import io.reactivex.Observable;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 *
 * @author KnowGroup
 */
public class Lesson_05_Filtering_Predicate {

    public static void main(String arg[]) {

        Observable.fromIterable(greekLetters())
                .firstElement()
                .subscribe(c -> log.accept("firstElement :: "+c))
                .dispose();

        Observable.fromIterable(greekLetters())
                .lastElement()
                .subscribe(c -> log.accept("lastElement :: "+c))
                .dispose();
        
        Observable.fromIterable(greekLetters())
                .take(4)
                .subscribe(c -> log.accept("take :: "+c))
                .dispose();
        
        Observable.fromIterable(greekLetters())
                .takeLast(10)
                .subscribe(c -> log.accept("takeLast :: "+c))
                .dispose();
        
        Observable.fromIterable(greekLetters())
                .lastOrError()
                .subscribe(c -> log.accept("lastOrError :: "+c))
                .dispose();
        
        Observable.fromIterable(Collections.EMPTY_LIST)
                .defaultIfEmpty("ALPHA")
                .subscribe(c -> log.accept("defaultIfEmpty :: "+c))
                .dispose();
        
        Observable.fromIterable(greekLetters())
                .elementAt(19)
                .subscribe(c -> log.accept("elementAt :: "+c))
                .dispose();
        
         Observable.fromIterable(greekLetters())
                .elementAtOrError(19)
                .onErrorReturn(e -> e.toString())
                .subscribe(c -> log.accept("elementAtOrError :: "+c))
                .dispose();
         
        
         Observable.fromIterable(greekLetters())
                .distinct()
                .subscribe(c -> log.accept("distinct :: "+c))
                .dispose();
        
    }

    private static List<String> greekLetters() {
        List<String> result = new CopyOnWriteArrayList<>();
            result.add("Aplha");
            result.add("Beta");
            result.add("Gamma");
            result.add("Theta");
            result.add("Theta");
            result.add("Lamda");
            result.add("Deta");
        return result;
    }
    private static Consumer<Object> log = (o) -> System.out.println(o.toString());
}