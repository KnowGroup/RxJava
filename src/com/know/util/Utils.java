package com.know.util;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 *
 * @author KnowGroup
 */
public interface Utils {

    public static Consumer<Object> log = o -> System.out.println(o.toString());
    
    public static List<String> greekLetters() {
        List<String> result = new CopyOnWriteArrayList<>();
            result.add("Aplha");
            result.add("Beta");
            result.add("Gamma");
            result.add("Theta");
            result.add("Theta");
            result.add("Lamda");
            result.add("Deta");
            result.add("Deta");
            result.add("Deta");
            result.add("Deta");
        return result;
    }
    
    public static List<String> alphaLetters() {
        List<String> result = new CopyOnWriteArrayList<>();
            result.add("One");
            result.add("Two");
            result.add("Three");
            result.add("Four");
            result.add("Five");
            result.add("Six");
            result.add("Seven");
            result.add("Eight");
            result.add("Nine");
            result.add("Ten");
        return result;
    }
    
    public static List<BigInteger> bigIntegers() {
        List<BigInteger> result = new CopyOnWriteArrayList<>();
            result.add(new BigInteger("12"));
            result.add(new BigInteger("1"));
            result.add(new BigInteger("132422"));
            result.add(new BigInteger("3223"));
            result.add(new BigInteger("999"));
            result.add(new BigInteger("-72321039"));
            result.add(new BigInteger("90"));
            result.add(new BigInteger("999999910"));
        return result;
    }
    
    public static List<Integer> fibonacciList() {
        List<Integer> result = new CopyOnWriteArrayList<>();
            result.add(0);
            result.add(1);
            result.add(2);
            result.add(3);
            result.add(5);
            result.add(8);
            result.add(13);
            result.add(21);
            result.add(33);
            result.add(54);
            result.add(87);
        return result;
    }
}
