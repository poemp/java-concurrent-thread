package org.poem.concurrent.blockingQueue;

import org.poem.concurrent.entity.Consumer;
import org.poem.concurrent.entity.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueExample {

    public static void main(String[] args) throws Exception {

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

        ExecutorService service = Executors.newFixedThreadPool(2);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        service.execute(producer);
        service.execute(consumer);

        Thread.sleep(1000);

        service.shutdown();
    }
}
