package qihui.sun.JUC;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserExample {
    public static void main(String[] args) {
        // 创建一个 Phased，初始阶段为 0
        Phaser phaser = new Phaser(5); // 初始注册 5 个参与者

        // 创建 5 个线程，模拟 5 个任务
        for (int i = 0; i < 5; i++) {
            int taskId = i + 1;
            new Thread(() -> {
                try {
                    System.out.println("Task " + taskId + " is starting phase 1...");
                    doSomeWork(taskId, 1);
                    phaser.arriveAndAwaitAdvance(); // 完成第一阶段，等待所有线程

                    System.out.println("Task " + taskId + " is starting phase 2...");
                    doSomeWork(taskId, 2);
                    phaser.arriveAndAwaitAdvance(); // 完成第二阶段，等待所有线程

                    System.out.println("Task " + taskId + " is starting phase 3...");
                    doSomeWork(taskId, 3);
                    phaser.arriveAndAwaitAdvance(); // 完成第三阶段，等待所有线程

                    System.out.println("Task " + taskId + " has completed all phases.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Thread-" + taskId).start();
        }

        // 主线程等待所有任务完成所有阶段
        phaser.arriveAndDeregister(); // 主线程也参与同步
        while (!phaser.isTerminated()) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All tasks have completed all phases.");
    }

    private static void doSomeWork(int taskId, int phase) throws InterruptedException {
        long duration = (long) (Math.random() * 1000);
        System.out.println("Task " + taskId + " is working on phase " + phase + " for " + duration + " ms.");
        TimeUnit.MILLISECONDS.sleep(duration);
    }
}
