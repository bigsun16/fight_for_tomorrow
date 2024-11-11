package qihui.sun.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new MyFutureTask(4));
        new Thread(task).start();
        System.out.println(task.get());
    }

}

class MyFutureTask implements Callable<Integer> {
    private final int num;

    public MyFutureTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        return num * num;
    }
}
