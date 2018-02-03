package org.poem.concurrent.cyclicBarrier;

import org.poem.concurrent.cyclicBarrier.entity.CyclicBarrierRunable;

import java.util.concurrent.CyclicBarrier;

public class CycliBarrireTest {


    public static void main(String[] args) {
        Runnable runnableAction = new Runnable() {
            public void run() {
                System.err.println("BarrierAction 1 executed.");
            }
        };

        Runnable runnableAction2 = new Runnable() {
            public void run() {
                System.err.println("BarrierAction 2 executed.");
            }
        };
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,runnableAction);
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2,runnableAction2);

        CyclicBarrierRunable cyclicBarrierRunable = new CyclicBarrierRunable(cyclicBarrier,cyclicBarrier2);
        CyclicBarrierRunable cyclicBarrierRunable2 = new CyclicBarrierRunable(cyclicBarrier,cyclicBarrier2);

        new Thread(cyclicBarrierRunable).start();
        new Thread(cyclicBarrierRunable2).start();
    }
}
