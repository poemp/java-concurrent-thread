package org.poem.concurrent.entity;

import java.util.concurrent.BlockingQueue;

/**
 * 线程消费者
 */
public class Consumer implements Runnable {

    protected BlockingQueue<String> queue;

    /**
     * constructor
     * @param queue
     */
    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
