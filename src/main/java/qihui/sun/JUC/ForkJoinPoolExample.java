package qihui.sun.JUC;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExample {

    public static void main(String[] args) {
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1; // 初始化数组
        }

        // 创建 ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 提交任务并获取结果
        int sum = forkJoinPool.invoke(new SumTask(array, 0, array.length));

        System.out.println("Sum of the array: " + sum);
    }

    // 定义一个 RecursiveTask 子类
    static class SumTask extends RecursiveTask<Integer> {
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            // 如果任务足够小，直接计算
            if (end - start <= 1000) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            }

            // 否则，将任务分解为两个子任务
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            // 异步执行子任务
            leftTask.fork();
            rightTask.fork();

            // 等待子任务完成并合并结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            return leftResult + rightResult;
        }
    }
}