package qihui.sun.JUC;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static final CountDownLatch count = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                count.countDown();
            }, i + "").start();
        }

        count.await();
        System.out.println("over");
    }
}
