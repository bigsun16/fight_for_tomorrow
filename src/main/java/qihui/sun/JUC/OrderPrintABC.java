package qihui.sun.JUC;

import java.util.concurrent.*;

public class OrderPrintABC {
    public static void main(String[] args) throws InterruptedException {
//        new Task("A", 0).start();
//        new Task("B", 1).start();
//        new Task("C", 2).start();

        demo2();
    }

    public static void demo2() throws InterruptedException {
        SynchronousQueue<Runnable> tasks = new SynchronousQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    tasks.put(()->System.out.print("A"));
                    tasks.put(()->System.out.print("B"));
                    tasks.put(()->System.out.println("C"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
//        new Thread(()->{
            try {
                for (int i = 0; i < 30; i++) {
                    executorService.submit(tasks.take());
//                    TimeUnit.MILLISECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//        }).start();
    }
}

class Task extends Thread {
    private final int order;
    private final String letter;
    private static final Object LOCK = new Object();
    private static volatile int currentRound = 0;

    public Task(String letter, int order) {
        this.letter = letter;
        this.order = order;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (LOCK) {
                while (currentRound % 3 != order) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(letter);
                currentRound++;
                if (currentRound % 3 == 0) {
                    System.out.println();
                }
                LOCK.notifyAll();
            }
        }
    }
}

