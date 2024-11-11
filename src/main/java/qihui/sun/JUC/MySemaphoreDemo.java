package qihui.sun.JUC;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MySemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        // 创建5个线程，模拟5个任务请求资源
        for (int i = 0; i < 5; i++) {
            int taskId = i + 1;
            new Thread(() -> {
                try {
                    // 请求一个许可
                    semaphore.acquire();
                    System.out.println("Task " + taskId + " acquired a permit.");

                    // 模拟耗时任务
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Task " + taskId + " do something");
                    // 释放许可
                    semaphore.release();
                    System.out.println("Task " + taskId + " released a permit.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Thread-" + taskId).start();
        }
    }
}
