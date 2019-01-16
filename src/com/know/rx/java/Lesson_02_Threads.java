package com.know.rx.java;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;


/**
 *
 * @author KnowGroup
 */
public class Lesson_02_Threads {

    public static void main(String[] arg){
        
        log.accept("Driving Thread :: "+Thread.currentThread().getName());
        
        /*
        No Scheduler | Synchronous calling
         */
        Observable<Integer> o_list = Observable.fromIterable(fibonacciList());
        o_list.subscribe(
                n -> log.accept(" onNext :: "+n+" | "+Thread.currentThread().getName()), 
                e -> log.accept(" onError :: "+e+" | "+Thread.currentThread().getName()), 
                ()-> log.accept(" onCompleted :: | "+Thread.currentThread().getName()));
        
        /*
            subscribeOn Schedulers.newThread()
        */
        
        final Observable<Integer> o_list2 = Observable.fromIterable(fibonacciList());
        o_list2.subscribeOn(Schedulers.newThread())
               .subscribe(
                n -> log.accept(" onNext :: "+n+" | "+Thread.currentThread().getName()), 
                e -> log.accept(" onError :: "+e+" | "+Thread.currentThread().getName()), 
                ()-> log.accept(" onCompleted :: | "+Thread.currentThread().getName()));
        
        /*
            observeOn Schedulers.newThread()            
        */        
        final Observable<Integer> o_list3 = Observable.fromIterable(fibonacciList());
        o_list3.observeOn(Schedulers.newThread())
               .subscribe(
                n -> log.accept(" onNext :: "+n+" | "+Thread.currentThread().getName()), 
                e -> log.accept(" onError :: "+e+" | "+Thread.currentThread().getName()), 
                ()-> log.accept(" onCompleted :: | "+Thread.currentThread().getName()));
        
        /*
            observeOn Schedulers.io()            
        */        
        final Observable<Integer> o_list4 = Observable.fromIterable(fibonacciList());
        o_list4.observeOn(Schedulers.io())
               .subscribe(
                n -> log.accept(" onNext :: "+n+" | "+Thread.currentThread().getName()), 
                e -> log.accept(" onError :: "+e+" | "+Thread.currentThread().getName()), 
                ()-> log.accept(" onCompleted :: | "+Thread.currentThread().getName()));
        
        /*
         TODO Parallel Processing of Observers on next
        */
        final Observable<Integer> o_list5 = Observable.fromIterable(fibonacciList());
        o_list5.subscribeOn(Schedulers.newThread())
               //.parallel(n -> n.filter(i -> i %2 ==0))
               .subscribe(
                n -> log.accept(" onNext :: "+n+" | "+Thread.currentThread().getName()), 
                e -> log.accept(" onError :: "+e+" | "+Thread.currentThread().getName()), 
                ()-> log.accept(" onCompleted :: | "+Thread.currentThread().getName()));
        
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
