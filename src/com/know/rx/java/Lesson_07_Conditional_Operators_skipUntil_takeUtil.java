package com.know.rx.java;

import com.know.util.TimedEventSequence;
import com.know.util.Utils;
import static com.know.util.Utils.log;
import io.reactivex.schedulers.Schedulers;

/**
 *
 * @author KnowGroup
 */
public class Lesson_07_Conditional_Operators_skipUntil_takeUtil {

    public static void main(String[] arg){
                
        TimedEventSequence<String>  event = new TimedEventSequence<>(Utils.greekLetters(), 50);
        TimeTicker ticker = new TimeTicker(3000);
        event.toObservable()
               .subscribeOn(Schedulers.computation())
              .takeUntil(ticker.toObservable())
              .subscribe(n -> log.accept("Event 1 : "+n));

        event.start();
        ticker.start();
        
        
        try {
            log.accept("Sleeping Now.....");
            Thread.currentThread().sleep(6000);
        } catch (InterruptedException ex) {
        }finally{
            event.stop();
            ticker.stop();
        }
        
    }
}