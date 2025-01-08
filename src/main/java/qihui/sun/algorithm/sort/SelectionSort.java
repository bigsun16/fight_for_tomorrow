package qihui.sun.algorithm.sort;
// 选择排序 时间复杂度 O(n^2) 空间复杂度 O(1) 稳定排序 不稳定排序 算法思想：每次从未排序序列中找到最小（大）元素，存放到排序序列的起始位置。

/**
 * 选择排序
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定排序 不稳定排序
 * 算法思想：每次从未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 * 选择排序是不稳定的，因为相同元素可能在数组中被多次交换。
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                CheckSortIsOk.swap(arr, minIndex, i);
            }
        }
    }

}
