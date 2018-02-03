package org.poem.concurrent.cyclicBarrier.entity;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunable implements Runnable {


    CyclicBarrier cyclicBarrier = null;
    CyclicBarrier cyclicBarrier2 = null;

    public CyclicBarrierRunable(CyclicBarrier cyclicBarrier,CyclicBarrier cyclicBarrier2 ){
        this.cyclicBarrier = cyclicBarrier;
        this.cyclicBarrier2 = cyclicBarrier2;
    }


    public void run() {
        try {
            Thread.sleep(1000);
            System.err.println(Thread.currentThread().getName() + " waiting at barrier 1");

            this.cyclicBarrier.await();

            Thread.sleep(1000);
            System.err.println(Thread.currentThread().getName() + " waiting at barrier 2");

            this.cyclicBarrier2.await();

            System.err.println(Thread.currentThread().getName() + " done !");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
