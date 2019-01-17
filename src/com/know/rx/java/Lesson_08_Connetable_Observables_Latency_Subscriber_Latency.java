package com.know.rx.java;

import io.reactivex.observables.ConnectableObservable;
import static com.know.util.Utils.log;
import io.reactivex.schedulers.Schedulers;
/**
 *
 * @author KnowGroup
 */
public class Lesson_08_Connetable_Observables_Latency_Subscriber_Latency {
    
    public static void main(String[] arg) throws InterruptedException{
     
        TimeTicker ticker = new TimeTicker(500).start();
     
        ConnectableObservable<Long> connectableObservable = 
                ticker
                    .toObservable()
                    .publish();
     
        /*
            Doesn't work until start emitting until connect is called
        */
        connectableObservable
                .observeOn(Schedulers.newThread())
                .subscribe(n -> log.accept(n+" 1 :: "+Thread.currentThread().getName()));
        
        connectableObservable
                .observeOn(Schedulers.computation())
                .subscribe(n -> {
                            log.accept(n+" 2 :: "+Thread.currentThread().getName());
                            log.accept("Subscriber 2 is sleeping .... ");
                            Thread.currentThread().sleep(1000);
                        });
        
        log.accept("Sleeping .... ");
        Thread.currentThread().sleep(3000);
        
        log.accept("Connecting Now .... ");
        connectableObservable.connect();
        
        Thread.currentThread().sleep(5000);
        log.accept("Five seconds down ....STOP Ticker");
        
        ticker.stop();
        Thread.currentThread().sleep(5000);
        
        log.accept("Notice despite Ticker has been stops , 2nd Sub Ticker still keeps consuming pending messages .... ");
        System.exit(0);
    }
}
