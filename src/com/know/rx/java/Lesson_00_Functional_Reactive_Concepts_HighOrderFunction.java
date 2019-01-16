package com.know.rx.java;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author KnowGroup
 */
public class Lesson_00_Functional_Reactive_Concepts_HighOrderFunction {

    /*
        High order function are the function that take function as parameters 
        and returns function as parameter
    */
    private Supplier<Double> sumAndMultiply(final Integer x,
            final Integer y,
            final Function<Integer,Integer> multiplier){
        return () -> {
            if(multiplier!=null){
                return (double) multiplier.apply(x) + multiplier.apply(y);
            }
            return (double)x + y;
        };
    }
            
    
    public static void main(String[] arg){
        Double output;
        
        Lesson_00_Functional_Reactive_Concepts_HighOrderFunction l = new Lesson_00_Functional_Reactive_Concepts_HighOrderFunction();
        Supplier<Double> s = l.sumAndMultiply(2, 2, n -> n * 3);
        output = s.get(); // Lazy Execution when calling s.get()
        log.accept(output);
    }
    
    private static Consumer<Object> log = o -> System.out.println(o.toString());
}
