package qihui.sun.JUC;

import java.util.concurrent.TimeUnit;

public class DeadLock {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(()->{
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+" have lock1 try to get lock2");
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+" have lock2");
                }
            }
        },"thread1").start();
        new Thread(()->{
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+" have lock2 try to get lock1");
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName()+" have lock1");
                }
            }
        },"thread2").start();
    }


}
