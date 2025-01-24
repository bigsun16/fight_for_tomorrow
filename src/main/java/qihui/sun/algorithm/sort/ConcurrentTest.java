package qihui.sun.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentTest {
    public static final int times = 10000;
    public static final int maxNum = 1000;
    public static final int maxSize = 1000;
    public static final int cores = 10;
    public static final AtomicInteger count = new AtomicInteger(0);
    public static final AtomicBoolean result = new AtomicBoolean(false);
    public static final CountDownLatch latch = new CountDownLatch(4);
    public static final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < cores; i++) {
            executor.execute(ConcurrentTest::task);
//            task();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
        System.out.println("结果：" + result.get());
        System.out.println("成功次数：" + count.get());
    }

    public static void task() {
        for (int i = 0; i < times / cores; i++) {
            int[] arr = CheckSortIsOk.generatorRandomArr(maxSize, maxNum);
            int[] arr2 = CheckSortIsOk.copyArray(arr);
//            SelectionSort.sort(arr);//11731
//            BubbleSort.sort(arr);//29463  23580
//            InsertionSort.sort(arr);//7750
//            MergeSort.sort(arr);//7251
//            QuickSort.sort(arr);//6356
            HeapSort.sort(arr);//5502
            Arrays.sort(arr2);
            result.set(Arrays.equals(arr, arr2));
//            if (!result.get()) {
//                break;
//            }
            count.incrementAndGet();
        }
        latch.countDown();
    }
}
