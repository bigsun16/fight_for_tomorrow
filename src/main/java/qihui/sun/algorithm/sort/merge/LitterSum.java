package qihui.sun.algorithm.sort.merge;

import java.util.Arrays;

/**
 * 小和问题
 * 给定一个数组，求每个数左边比当前数小的数的和。
 * 例如：
 * 数组：[1,3,4,2,5]
 * 1左边比1小的数有0个，2左边比2小的数有1个，3左边比3小的数有1个，4左边比4小的数有2个，5左边比5小的数有3个，所以小和为1+2+3+4+5=15
 * 归并排序解法
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 思路： 归并排序中，归并排序的递归调用中，每次递归调用都会产生一个临时数组，所以空间复杂度为O(n)
 * 在归并排序的过程中，我们可以计算出小和。
 */
public class LitterSum {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(getLitterSum(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int getLitterSum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        return sort(arr, left, right);
    }

    private static int sort(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int midIndex = left + ((right - left) >> 1);
        int lSum = sort(arr, left, midIndex);
        int rSum = sort(arr, midIndex + 1, right);
        return lSum + rSum + mergeSum(arr, left, midIndex, right);
    }

    private static int mergeSum(int[] arr, int left, int midIndex, int right) {
        int sum = 0;
        int[] newArr = new int[right - left + 1];
        int lStart = left;
        int rStart = midIndex + 1;
        int newIndex = 0;
        while (lStart <= midIndex && rStart <= right) {
            sum += arr[lStart] < arr[rStart] ? (arr[lStart] * (right - rStart + 1)) : 0;
            newArr[newIndex++] = arr[lStart] < arr[rStart] ? arr[lStart++] : arr[rStart++];
        }
        if (lStart > midIndex) {
            System.arraycopy(arr, rStart, newArr, newIndex, right - rStart + 1);
        } else {
            System.arraycopy(arr, lStart, newArr, newIndex, midIndex - lStart + 1);
        }
        System.arraycopy(newArr, 0, arr, left, newArr.length);
        return sum;
    }
}