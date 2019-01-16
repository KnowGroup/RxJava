package com.know.rx.java;

import com.know.util.Utils;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KnowGroup
 */
public class Lesson_05_Filtering_Time_Based_Sampling {

    public static void main(String[] arg){
         TimeTicker timeTicker = new TimeTicker(10);
         timeTicker.start();
         
        try {
            timeTicker.toObservable()
                    .sample(1, TimeUnit.SECONDS) // Sampling Operation would restrict consuming Ticker emmits for 1 second even ticker is emmiting every 10 milli seconds
                    .subscribe( t -> Utils.log.accept("Tick : "+ t), 
                                e -> Utils.log.accept("TIMEOUT ! "+e.getMessage()));       
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Lesson_05_Filtering_Time_Based_Sampling.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            timeTicker.stop();
        }
        System.exit(0);
    }
    
}

class TimeTicker{
    
    private final BehaviorSubject<Long> tickerSubject;
    private final long interval;
    
    private long lastTick;
    private Thread tickerThread;
    private volatile boolean paused;

    public TimeTicker(long interval) {
        
        this.lastTick = System.currentTimeMillis();
        this.tickerSubject = BehaviorSubject.createDefault(lastTick);
        this.interval = interval;
        this.paused = false;
    }
    
    public Observable<Long> toObservable(){
        return tickerSubject;
    }
    
    public synchronized void start(){
        if(tickerThread != null){
            return;
        }
        
        tickerThread = new Thread(() ->{
           try {
               while(Thread.interrupted() == false){
                   try{ Thread.sleep(20); } catch (InterruptedException e){
                       break;
                   }
                
                   if(paused)
                       continue;
                   
                   long currentTime = System.currentTimeMillis();
                   if(currentTime - lastTick > interval){
                       lastTick = currentTime;
                       tickerSubject.onNext(lastTick);
                       Utils.log.accept(lastTick+" :: "+Thread.currentThread().getName());                       
                   }
               }
           }catch(Exception e){
               tickerSubject.onError(e);
           }
        tickerSubject.onComplete();
        },"TickerThread");
        tickerThread.start();
    }
    
    public void pause(){
        this.paused = true;
    }
    
    public synchronized void stop(){
        if(tickerThread == null){
            return;
        }
        
        tickerThread.interrupt();
        try {
            tickerThread.join();
        }catch(InterruptedException e){
            
        }
    }
    
}
