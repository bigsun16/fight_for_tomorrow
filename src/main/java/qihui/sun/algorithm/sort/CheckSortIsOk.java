package qihui.sun.algorithm.sort;

import qihui.sun.algorithm.sort.quick.QuickSort;

import java.util.Arrays;

public class CheckSortIsOk {
    public static void main(String[] args) {
        int times = 500000;
        int maxNum = 1000;
        int maxSize = 1000;
        boolean result = false;
        long l = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] arr = generatorRandomArr(maxSize, maxNum);
            int[] arr2 = copyArray(arr);
//            SelectionSort.sort(arr);//67272
//            BubbleSort.sort21(arr);//188299
//            InsertionSort.sort2(arr);//80109
//            MergeSort.sort(arr);//35163
            QuickSort.sort(arr);//29229
            Arrays.sort(arr2);
            result = Arrays.equals(arr, arr2);
            if (!result) {
                break;
            }
        }
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(result);
    }

    public static int[] copyArray(int[] arr) {
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        return arr2;
    }

    public static int[] generatorRandomArr(int maxSize, int maxNum) {
        int count = (int) (Math.random() * (maxSize + 1));
        if (count == 0) {
            return generatorRandomArr(maxSize, maxNum);
        }
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxNum + 1)) - (int) (Math.random() * (maxNum + 1));
        }
        return arr;
    }

    public static void swap2(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
