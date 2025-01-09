package qihui.sun.algorithm.sort.merge;

/**
 * 归并排序
 * 时间复杂度O(n*log2n) 空间复杂度O(N) 稳定
 */
public class MergeSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        sort(arr, left, right);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int midIndex = left + ((right - left) >> 1);
        sort(arr, left, midIndex);
        sort(arr, midIndex + 1, right);
        mergeSort(arr, left, midIndex, right);
    }

    private static void mergeSort(int[] arr, int left, int midIndex, int right) {
        int[] newArray = new int[right - left + 1];
        int lStart = left;
        int rStart = midIndex + 1;
        int index = 0;
        while (lStart <= midIndex && rStart <= right) {
            newArray[index++] = arr[lStart] > arr[rStart] ? arr[rStart++] : arr[lStart++];
        }
        if (lStart > midIndex) {
            System.arraycopy(arr, rStart, newArray, index, right - rStart + 1);
        } else {
            System.arraycopy(arr, lStart, newArray, index, midIndex - lStart + 1);
        }
        System.arraycopy(newArray, 0, arr, left, newArray.length);
    }


}
