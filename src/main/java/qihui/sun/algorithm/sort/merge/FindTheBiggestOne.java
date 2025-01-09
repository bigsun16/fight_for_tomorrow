package qihui.sun.algorithm.sort.merge;

import qihui.sun.algorithm.sort.CheckSortIsOk;

import java.util.Arrays;

public class FindTheBiggestOne {

    public static void main(String[] args) {
        boolean result = true;
        for (int i = 0; i < 100000; i++) {
            int[] arr = CheckSortIsOk.generatorRandomArr(100, 100);
            int i1 = find(arr, 0, arr.length - 1);
//            int i2 = baseFind(arr, 0, arr.length - 1);
            int i3 = Arrays.stream(arr).max().getAsInt();
            if (i1 != i3) {
                System.out.println(i1 + "=========" + i3);
                result = false;
                break;
            }
        }
        System.out.println(result);
    }

    public static int find(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start < 0 || end > arr.length - 1 || start > end) {
            return -1;
        }
        if (arr.length == 1 || start == end) {
            return arr[start];
        }
        int midIndex = start + ((end - start) >> 1);
        int i = find(arr, start, midIndex);
        int i1 = find(arr, midIndex + 1, end);
        return Math.max(i, i1);

    }

    public static int baseFind(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("no arr");
        }
        int big = arr[0];
        for (int i = start; i <= end; i++) {
            big = Math.max(big, arr[i]);
        }
        return big;
    }
}
