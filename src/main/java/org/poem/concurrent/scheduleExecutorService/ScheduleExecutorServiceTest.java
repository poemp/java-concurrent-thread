package org.poem.concurrent.scheduleExecutorService;

import java.util.concurrent.*;

public class ScheduleExecutorServiceTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Callable() {

            @Override
            public String call() {
                System.err.println("Executors !");
                return  "ExecutorService.";
            }
        },10 , TimeUnit.SECONDS);

        System.err.println(scheduledFuture.get());
        scheduledExecutorService.shutdown();

    }
}
