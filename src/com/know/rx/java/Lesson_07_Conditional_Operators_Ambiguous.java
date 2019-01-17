package com.know.rx.java;

import com.know.util.TimedEventSequence;
import com.know.util.Utils;
import static com.know.util.Utils.log;

/**
 *
 * @author KnowGroup
 */
public class Lesson_07_Conditional_Operators_Ambiguous {

    public static void main(String[] arg){
                
        TimedEventSequence<String>  event1 = new TimedEventSequence<>(Utils.greekLetters(), 100);
        TimedEventSequence<String>  event2 = new TimedEventSequence<>(Utils.alphaLetters(), 500);
        
//        Observable.amb(event1.toObservable());

        event1.toObservable()
              .subscribe(n -> log.accept("Event 1 : "+n));

        event2.toObservable()
              .subscribe(n -> log.accept("Event 2 : "+n));

        event1.start();
        event2.start();
        
        try {
            log.accept("Sleeping Now.....");
            Thread.currentThread().sleep(20000);
        } catch (InterruptedException ex) {
        }finally{
            event1.stop();
            event2.stop();
        }
        
    }
}