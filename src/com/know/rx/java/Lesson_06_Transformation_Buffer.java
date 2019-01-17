package com.know.rx.java;

import com.know.util.Utils;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KnowGroup
 */
public class Lesson_06_Transformation_Buffer {

    public static void main(String[] arg){
         TimeTicker timeTicker = new TimeTicker(100);
         timeTicker.start();
         
        try {
            timeTicker.toObservable()
                    .buffer(1, TimeUnit.SECONDS)
                    .subscribe( tickList -> {
                                    Utils.log.accept("========== BUFFER onNext ===================");
                                    Utils.log.accept("Tick Count : "+ tickList.size());
                                    tickList.forEach(tick -> Utils.log.accept(tick));                                    
                                }, 
                                e -> Utils.log.accept("TIMEOUT ! "+e.getMessage()),
                                () -> Utils.log.accept("========== BUFFER onComplete ==================="));       
            
            Thread.currentThread().sleep(10000);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Lesson_06_Transformation_Buffer.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            timeTicker.stop();
        }
        System.exit(0);
    }
    
}