package com.know.rx.java;

/**
 *
 * @author KnowGroup
 */
public class Lesson_00_Functional_Reactive_Concepts_PureAndImpure {

    /*
      Pure function always return the same result for a given set of Parameter
      values.
    */
    public double pure_function(int n){
        return n*n;
    }
    /*
       Impure function are not thread safe results varry.
    */
    double state = -1;
    public double impure_function(int n){
        state = (++state % 3);
        return n * 2 + state;
    }
    
    public static void main(String[] arg){
        Lesson_00_Functional_Reactive_Concepts_PureAndImpure l = new Lesson_00_Functional_Reactive_Concepts_PureAndImpure();
        
        for(int i = 1;i<10;i++){
            if(l.pure_function(5) != 25){
                throw new RuntimeException("Not Pure Function");
            }
        }
        
        for(int i = 1;i<100;i++){
            System.out.println("Impure :: "+l.impure_function(5));
        }
    }
}
