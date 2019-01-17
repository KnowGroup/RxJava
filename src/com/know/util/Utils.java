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
}
