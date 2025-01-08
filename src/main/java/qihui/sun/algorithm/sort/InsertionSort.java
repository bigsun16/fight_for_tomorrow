package qihui.sun.algorithm.sort;

/**
 * 插入排序
 * 插入排序的思想是将数组分为已排序和未排序两部分，每次从未排序部分取出第一个元素，
 * 从已排序部分开始，找到合适的插入位置，将元素插入到合适的位置，然后继续从未排序部分取出下一个元素，
 * 继续进行插入排序，直到未排序部分为空。
 * 插入排序的优点是：对于小规模的数据排序，插入排序的性能较好。
 * 插入排序的缺点是：对于大规模数据排序，插入排序的性能较差。
 * 插入排序的时间复杂度为O(n^2)，空间复杂度为O(1)。
 */
public class InsertionSort {

    public static void sort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                CheckSortIsOk.swap(arr, j, j - 1);
            }
        }
    }


    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                CheckSortIsOk.swap(arr, j, j - 1);
            }
        }
    }

}
