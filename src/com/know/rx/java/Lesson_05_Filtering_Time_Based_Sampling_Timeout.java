package com.know.rx.java;

import com.know.util.Utils;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KnowGroup
 */
public class Lesson_05_Filtering_Time_Based_Sampling_Timeout {

    public static void main(String[] arg){
         TimeTicker timeTicker = new TimeTicker(10);
         timeTicker.start();
         
        try {
            timeTicker.toObservable()
                    .timeout(3, TimeUnit.SECONDS)
                    .sample(1, TimeUnit.SECONDS) // Sampling Operation would restrict consuming Ticker emmits for 1 second even ticker is emmiting every 10 milli seconds
                    .subscribe( t -> Utils.log.accept("Tick : "+ t), 
                                e -> Utils.log.accept("TIMEOUT ! "+e.getMessage()));       
            Thread.currentThread().sleep(1000);
            
            Utils.log.accept("Pausing Time Ticker...");
            timeTicker.pause();
            
            Thread.currentThread().sleep(10000);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Lesson_05_Filtering_Time_Based_Sampling_Timeout.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            timeTicker.stop();
        }
        System.exit(0);
    }
    
}