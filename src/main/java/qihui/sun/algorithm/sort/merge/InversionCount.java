package qihui.sun.algorithm.sort.merge;

import java.util.Arrays;

/**
 * 逆序对
 * 定义：在数组中，如果满足i < j 且 a[i] > a[j]，则(a[i], a[j])构成一个逆序对。
 * 逆序对的数量即为数组的归并排序中，总的合并次数。
 * 逆序对问题：给定一个数组，求出这个数组的逆序对的总数。
 * 例：[7,5,6,4]，逆序对为(7,5)、(7,6)、(7,4)、(5,4)、(6,4)，共5个。
 */
public class InversionCount {
    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        System.out.println(inversionCount(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int inversionCount(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        return getCount(arr, left, right);
    }

    private static int getCount(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int midIndex = left + ((right - left) >> 1);
        int lCount = getCount(arr, left, midIndex);
        int rCount = getCount(arr, midIndex + 1, right);
        return lCount + rCount + mergeCount(arr, left, midIndex, right);
    }

    private static int mergeCount(int[] arr, int left, int midIndex, int right) {
        int count = 0;
        int[] newArr = new int[right - left + 1];
        int lStart = left;
        int rStart = midIndex + 1;
        int newIndex = 0;
        while (lStart <= midIndex && rStart <= right) {
            count += arr[lStart] > arr[rStart] ? right - rStart + 1 : 0;
            newArr[newIndex++] = arr[lStart] < arr[rStart] ? arr[lStart++] : arr[rStart++];
        }
        if (rStart > right) {
            System.arraycopy(arr, lStart, newArr, newIndex, midIndex - lStart + 1);
        } else {
            System.arraycopy(arr, rStart, newArr, newIndex, right - rStart + 1);
        }
        System.arraycopy(newArr, 0, arr, left, newArr.length);
        return count;
    }
}
