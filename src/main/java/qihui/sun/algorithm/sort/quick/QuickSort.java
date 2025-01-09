package qihui.sun.algorithm.sort.quick;

import qihui.sun.algorithm.sort.CheckSortIsOk;

/**
 * 快速排序
 * 描述：快速排序是冒泡排序的改进版，通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分
 * 数据分别进行快速排序，整个排序过程可以递归进行，使整个数据变成有序序列。
 * 时间复杂度：O(nlog2n)，空间复杂度O(log2n)
 * 稳定性：不稳定
 */
public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        quickSort(arr, left, right);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int randomIndex = (int) (Math.random() * (right - left + 1)) + left;
        int randomNum = arr[randomIndex];
        int index = left;
        int lIndex = left;
        int rIndex = right;
        while (index <= rIndex) {
            if (arr[index] == randomNum) {
                index++;
            } else if (arr[index] > randomNum) {
                CheckSortIsOk.swap2(arr, index, rIndex--);
            } else {
                CheckSortIsOk.swap2(arr, index++, lIndex++);
            }
        }
        quickSort(arr, left, lIndex - 1);
        quickSort(arr, rIndex + 1, right);

    }
}
