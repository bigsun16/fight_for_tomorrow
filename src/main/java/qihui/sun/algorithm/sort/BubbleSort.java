package qihui.sun.algorithm.sort;

/**
 * 冒泡排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        sort2(arr);
    }

    private static void sort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        boolean lFlag = true, rFlag = true;
        while (left <= right) {
            for (int i = 0; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    CheckSortIsOk.swap2(arr, i, i + 1);
                    lFlag = false;
                }
            }
            right--;
            if (lFlag) {
                return;
            }
            for (int i = right; i > 0; i--) {
                if (arr[i - 1] > arr[i]) {
                    CheckSortIsOk.swap2(arr, i, i - 1);
                    rFlag = false;
                }
            }
            left++;
            if (rFlag) {
                return;
            }
        }
    }


    private static void sort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        boolean flag = true;
        for (int length = arr.length; length > 0; length--) {
            for (int i = 0; i < length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    CheckSortIsOk.swap2(arr, i, i + 1);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

}
