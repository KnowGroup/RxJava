package com.know.rx.java;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author KnowGroup
 */
public class Lesson_00_Functional_Reactive_Concepts_FunctionAsParameter {

    private static String functionAtClassLevel(String x,String y){return x+y;}
    private String functionAtInstanceLevel(String x,String y){return x+y;}
    
    private String functionAsParameter(String x , String y, Function<String,String> transformer){
        if(transformer != null){
            x = transformer.apply(x);
            y = transformer.apply(y);
        }
        return x + y;
    }
    public static void main(String[] arg){
    
        String output;
        
        BiFunction<String, String, String> functionAsParameter = (x,y) -> x+y;
        output = functionAsParameter.apply("RxJava", " 1");
        log.accept(output);
        
        functionAsParameter = Lesson_00_Functional_Reactive_Concepts_FunctionAsParameter::functionAtClassLevel;
        output = functionAsParameter.apply("RxJava", " 2");
        log.accept(output);
        
        Lesson_00_Functional_Reactive_Concepts_FunctionAsParameter l = new Lesson_00_Functional_Reactive_Concepts_FunctionAsParameter();
        functionAsParameter = l::functionAtInstanceLevel;
        output = functionAsParameter.apply("RxJava", " 3");
        log.accept(output);
        
        Function<String,String> toLower = s -> s.toLowerCase();
        output = l.functionAsParameter("Rx", "Java", toLower);
        log.accept(output);
      
        output = l.functionAsParameter("Rx", "Java", s -> s.toUpperCase());
        log.accept(output);
    }
    
    static Consumer<Object> log = o -> System.out.println(o.toString());
}
