package qihui.sun.algorithm.sort;

/**
 * 冒泡排序
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 */
public class BubbleSort {

    public static void sort21(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            boolean flagLeft = true;
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    CheckSortIsOk.swap(arr, i, i + 1);
                    flagLeft = false;
                }
            }
            if (flagLeft) {
                return;
            }
            right--;
            boolean flagRight = true;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    CheckSortIsOk.swap(arr, i, i - 1);
                    flagRight = false;
                }
            }
            if (flagRight) {
                return;
            }
            left++;
        }
    }

    public static void sort11(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    CheckSortIsOk.swap(arr, j, j - 1);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    //1,2,3,4,5,9,8,7,6,5,4,3,2,1
    public static void sort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            boolean flag = true;
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    CheckSortIsOk.swap(arr, i, i + 1);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
            right--;
            boolean flag2 = true;
            for (int i = right; i > left; i--) {
                if (arr[i - 1] > arr[i]) {
                    CheckSortIsOk.swap(arr, i - 1, i);
                    flag2 = false;
                }
            }
            if (flag2) {
                return;
            }
            left++;
        }

    }

    public static void sort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    CheckSortIsOk.swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

}
