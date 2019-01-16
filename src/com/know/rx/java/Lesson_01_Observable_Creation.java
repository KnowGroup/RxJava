package com.know.rx.java;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;


/**
 *
 * @author KnowGroup
 */
public class Lesson_01_Observable_Creation {

    public static void main(String[] arg){
        
        //Observable<Integer> single = Observable.from(1);
        /*
            Observable of iterator
         */
        final Observable<Integer> o_list = Observable.fromIterable(fibonacciList());
        Disposable subscribe = o_list.subscribe(n -> log.accept(n.toString()));
        subscribe.dispose();
        /*
            Observable on array
        */
        final Observable<Integer> o_array = Observable.fromArray(fibonacciArray());
        subscribe = o_array.subscribe((n)-> log.accept(n.toString()));
        subscribe.dispose();
        /*
            Obserable on FutureTask
        */
        log.accept("Obserable on FutureTask");
        final FutureTask<List<Integer>> future = new FutureTask<>(()->{
            return fibonacciList();
        });
        final Observable<List<Integer>> o_future = Observable.fromFuture(future);
        Scheduler computation = Schedulers.computation();
            
        computation.createWorker().schedule(()->{future.run();});
        o_future.subscribeOn(computation)
                .subscribe(list -> {list.forEach(i->log.accept(i));})
                .dispose();        
    }
    private static List<Integer> fibonacciList(){
        final List<Integer> fibonacci = new CopyOnWriteArrayList<>();
            fibonacci.add(1);
            fibonacci.add(2);
            fibonacci.add(3);
            fibonacci.add(5);
            fibonacci.add(8);
            fibonacci.add(13);
            fibonacci.add(21);
            fibonacci.add(34);
        return fibonacci;
    }
    
    private static Integer[] fibonacciArray(){
        return fibonacciList().toArray(new Integer[]{});
    } 
    
    private static Consumer<Object> log = (o)-> System.out.println(o.toString());
}
