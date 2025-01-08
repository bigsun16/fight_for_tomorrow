package qihui.sun.algorithm.search;

import qihui.sun.algorithm.sort.CheckSortIsOk;

import java.util.Arrays;

public class FindTheBiggestOne {

    public static void main(String[] args) {
        boolean result = true;
        for (int i = 0; i < 100000; i++) {
            int[] arr = CheckSortIsOk.generatorRandomArr(100, 100);
            int i2 = find(arr, 0, arr.length - 1);
            int i1 = baseFind(arr, 0, arr.length - 1);
//            int i1 = Arrays.stream(arr).max().getAsInt();
            if (i1 != i2) {
                System.out.println(i1 + "=========" + i2);
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
        int lResult = find(arr, start, midIndex);
        int rResult = find(arr, midIndex + 1, end);
        return Math.max(lResult, rResult);
    }

    public static int baseFind(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start < 0 || end > arr.length - 1 || start > end) {
            return -1;
        }
        if (arr.length == 1 || start == end) {
            return arr[start];
        }
        int maxNum = arr[start];
        for (int i = start; i <= end; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
            }
        }
        return maxNum;
    }
}
