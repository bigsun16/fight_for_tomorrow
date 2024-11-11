package qihui.sun.JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample {

    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(10,()->{
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("let's go!");
    });
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"done something...");
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"done some other thing...");
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            },i+"").start();
        }
    }
}
