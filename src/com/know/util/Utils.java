package com.know.util;

import java.util.function.Consumer;

/**
 *
 * @author KnowGroup
 */
public interface Utils {

    public static Consumer<Object> log = o -> System.out.println(o.toString());
}
