package org.poem.concurrent.forkJoinPool.recursiveAction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {

    private long workLoad = 0;

    /**
     * constructor
     *
     * @param workLoad
     */
    public MyRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {

        if (this.workLoad > 16) {
            System.err.println(" Splitting workLoad :" + this.workLoad);

            List<MyRecursiveAction> myRecursiveActions = new ArrayList<>();
            myRecursiveActions.addAll(createSubTask());

            for (MyRecursiveAction myRecursiveAction : myRecursiveActions) {
                myRecursiveAction.fork();
            }
        }else{
            System.err.println(" Doing workLoad myself:" + this.workLoad);
        }
    }

    /**
     * 创建任务
     * @return
     */
    private List<MyRecursiveAction> createSubTask() {
        List<MyRecursiveAction> myRecursiveActions = new ArrayList<>();

        myRecursiveActions.add(new MyRecursiveAction(this.workLoad / 2));
        myRecursiveActions.add(new MyRecursiveAction(this.workLoad / 2));

        return myRecursiveActions;
    }
}
