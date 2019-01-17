package com.know.rx.java;

import com.know.util.Utils;
import io.reactivex.Observable;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author KnowGroup
 */
public class Lesson_06_Transformation_GroupBy {
    public static void main(String[] arg){
        
        Observable.fromIterable(Utils.bigIntegers())
                .groupBy(keySelector -> keySelector.intValue()%2 == 0 ? "ODD" : "EVEN")
                .subscribe(observableGroupBy -> observableGroupBy.subscribe(l -> Utils.log.accept(l+" : "+observableGroupBy.getKey())));//Display one odd , one even
        
        final List<BigInteger> odd = new CopyOnWriteArrayList<>();
        final List<BigInteger> even = new CopyOnWriteArrayList<>();
        
        Observable.fromIterable(Utils.bigIntegers())
                .groupBy(keySelector -> keySelector.intValue()%2 == 0 ? "ODD" : "EVEN")
                .subscribe(observableGroupBy -> 
                        observableGroupBy.subscribe(l -> {
                            if(observableGroupBy.getKey().equals("ODD")){
                                odd.add(l);
                                   }else{
                                 even.add(l);
                            }},e -> Utils.log.accept(e.getCause())));//Collect seperately 
        
        odd.forEach(e -> Utils.log.accept(e));
        even.forEach(e -> Utils.log.accept(e));
    }
}
