package com.know.rx.java;

import io.reactivex.Observable;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 *
 * @author KnowGroup
 */
public class Lesson_05_Filtering_Predicate {

    public static void main(String arg[]) {

        Observable.fromIterable(bigIntegerList())
                .filter(n -> n.intValue() % 2 == 0)
                .subscribe(c -> log.accept(c))
                .dispose();

    }

    private static List<BigInteger> bigIntegerList() {
        List<BigInteger> result = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 300; i++) {
            result.add(new BigInteger(i + ""));
        }
        return result;
    }
    private static Consumer<Object> log = (o) -> System.out.println(o.toString());
}
