package org.poem.concurrent.forkJoinPool;

import org.poem.concurrent.forkJoinPool.recursiveAction.MyRecursiveAction;
import org.poem.concurrent.forkJoinPool.recursiveTask.MyRecursiveTask;

import java.util.concurrent.ForkJoinPool;

public class RecursiveActionTest {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool(4);

        MyRecursiveAction action = new MyRecursiveAction(24);
        pool.invoke(action);

        MyRecursiveTask recursiveTask = new MyRecursiveTask(24);
        long mergedResult =  (long)pool.invoke(recursiveTask);
        System.err.println("mergedResult:"  + mergedResult);
    }
}
