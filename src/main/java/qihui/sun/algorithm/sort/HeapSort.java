package qihui.sun.algorithm.sort;

/**
 * 堆排序
 * 完全二叉树中高度是logn
 * 所以堆排序的时间复杂度是O(n*log2n) 空间复杂度是O(1),不稳定
 * 第i个节点的左子节点为2i+1,右子节点为2i+2,父节点为(i-1)/2
 */
public class HeapSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //方法一
        for (int i = 0; i < arr.length; i++) {
            heepInsert(arr, i);
        }
        //方法二
        /*for (int length = arr.length - 1; length >= 0; length--) {
            heepify(arr, length, arr.length);
        }*/
        int heepSize = arr.length;
        while (heepSize > 0) {
            CheckSortIsOk.swap2(arr, 0, --heepSize);
            heepify(arr, 0, heepSize);
        }
    }

    //构造一个大根堆，每次新数字跟当前节点跟父节点比大小，如果比父节点大就交换
    private static void heepInsert(int[] arr, int index) {
        while (index > 0 && arr[index] > arr[(index - 1) >> 1]) {
            CheckSortIsOk.swap2(arr, index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
    }

    private static void heepify(int[] arr, int index, int heepSize) {
        int left = 2 * index + 1;
        while (left < heepSize) {
            int right = left + 1;
            int largest = right < heepSize && arr[right] > arr[left] ? right : left;
            if (arr[largest] > arr[index]) {
                CheckSortIsOk.swap2(arr, index, largest);
                index = largest;
                left = 2 * index + 1;
            } else {
                break;
            }
        }
    }
}
