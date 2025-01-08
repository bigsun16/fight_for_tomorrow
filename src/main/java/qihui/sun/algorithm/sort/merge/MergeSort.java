package qihui.sun.algorithm.sort.merge;

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
        if (left == right) {
            return;
        }
        int minIndex = left + ((right - left) >> 1);
        sort(arr, left, minIndex);
        sort(arr, minIndex + 1, right);
        merge(arr, left, minIndex, right);
    }

    private static void merge(int[] arr, int left, int midIndex, int right) {
        int[] newArr = new int[right - left + 1];
        int lStartIndex = left;
        int rStartIndex = midIndex + 1;
        int newIndex = 0;
        while (lStartIndex <= midIndex && rStartIndex <= right) {
            newArr[newIndex++] = arr[lStartIndex] < arr[rStartIndex] ? arr[lStartIndex++] : arr[rStartIndex++];
        }
        if (lStartIndex <= midIndex) {
            System.arraycopy(arr, lStartIndex, newArr, newIndex, midIndex - lStartIndex + 1);
        } else {
            System.arraycopy(arr, rStartIndex, newArr, newIndex, right - rStartIndex + 1);
        }

        System.arraycopy(newArr, 0, arr, left, newArr.length);
    }
}
