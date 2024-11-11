package qihui.sun.JUC;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // 模拟从不同服务获取数据的异步任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            simulateDelay(1000);
            return "Data from Service 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            simulateDelay(1500);
            return "Data from Service 2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            simulateDelay(1200);
            return "Data from Service 3";
        });

        // 组合多个异步任务的结果
        CompletableFuture<String> combinedFuture = CompletableFuture.allOf(future1, future2, future3)
                .thenApply(v -> {
                    try {
                        return "Combined Data: " +
                                future1.get() + ", " +
                                future2.get() + ", " +
                                future3.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                });

        // 处理最终结果
        combinedFuture.thenAccept(result -> {
            System.out.println("Final result: " + result);
        });

        // 防止主线程提前结束
        try {
            combinedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void simulateDelay(int delay) {
        try {
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
