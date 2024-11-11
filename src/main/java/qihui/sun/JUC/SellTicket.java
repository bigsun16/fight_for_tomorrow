package qihui.sun.JUC;

import java.util.concurrent.TimeUnit;

public class SellTicket {

    public static void main(String[] args) {
        new Window("1").start();
        new Window("2").start();
        new Window("3").start();
        new Window("4").start();
    }
}

class Window extends Thread {
    public static Integer TOTAL_TICKET_COUNT = 1000;

    public Window(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (TOTAL_TICKET_COUNT > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (Window.class) {
                if (TOTAL_TICKET_COUNT > 0) {
                    System.out.println(Thread.currentThread().getName() + " sell one ticket, " + --TOTAL_TICKET_COUNT + " tickets left");
                } else {
                    System.out.println("所有票已售罄");
                }
            }
        }
    }
}
