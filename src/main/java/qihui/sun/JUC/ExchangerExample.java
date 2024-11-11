package qihui.sun.JUC;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerExample {

    public static void main(String[] args) {
        // 创建一个 Exchanger 对象
        Exchanger<String> exchanger = new Exchanger<>();

        // 生产者线程
        Thread producer = new Thread(() -> {
            try {
                String data = "Hello from Producer";
                System.out.println("Producer is ready to exchange data: " + data);
                String receivedData = exchanger.exchange(data);
                System.out.println("Producer received data: " + receivedData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 消费者线程
        Thread consumer = new Thread(() -> {
            try {
                // 让消费者线程稍晚一点开始
                TimeUnit.SECONDS.sleep(1);
                String data = "Hello from Consumer";
                System.out.println("Consumer is ready to exchange data: " + data);
                String receivedData = exchanger.exchange(data);
                System.out.println("Consumer received data: " + receivedData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 启动生产者和消费者线程
        producer.start();
        consumer.start();
    }
}