package org.poem.concurrent.entity;

import java.util.concurrent.BlockingQueue;

/**
 * 线程生成者
 */
public class Producer implements Runnable {

    protected BlockingQueue<String> queue = null;

    /**
     * constructor
     * @param queue
     */
    public Producer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    /**
     * override for Runnable
     * can run do something for thread
     */
    public void run() {
        try{
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
