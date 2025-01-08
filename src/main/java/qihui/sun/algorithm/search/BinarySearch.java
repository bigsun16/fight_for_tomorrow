package qihui.sun.algorithm.search;

import qihui.sun.algorithm.sort.CheckSortIsOk;

import java.util.Arrays;

/**
 * 二分查找算法
 * 时间复杂度：O(logn) 空间复杂度：O(1)
 * 实现步骤：
 * 1.确定待查找数组中查找区间的左边界和右边界，初始化left=0，right=n-1
 * 2.当left<=right时，执行循环，否则退出循环
 * 3.在循环中，计算mid = (left+right)/2，如果mid==target，则返回mid
 * 4.如果mid<target，则将left=mid+1，继续循环
 * 5.如果mid>target，则将right=mid-1，继续循环
 * 6.如果循环结束，仍未找到target，则返回-1
 */
public class BinarySearch {
    public static void main(String[] args) {
        boolean result = true;
        for (int i = 0; i < 100000; i++) {
            int[] arr = CheckSortIsOk.generatorRandomArr(100, 100);
            if (arr.length == 0) {
                continue;
            }
            int num = arr[arr.length - 1];
            Arrays.sort(arr);
            int[] array = Arrays.stream(arr).distinct().toArray();
            int i1 = Arrays.binarySearch(array, num);
            int index = findIndex2(array, num);
            if (i1 != index) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }

    private static int findIndex2(int[] array, int num) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        if (num > array[right] || num < array[left]) {
            return -1;
        }
        if (num == array[right]) {
            return right;
        }
        if (num == array[left]) {
            return left;
        }
        while (left <= right) {
            int midIndex = left + ((right - left) >> 1);
            int midNum = array[midIndex];
            if (num > midNum) {
                left = midIndex + 1;
            } else if (num < midNum) {
                right = midIndex - 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

    public static int findIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        if (num > arr[right] || num < arr[left]) {
            return -1;
        }
        if (num == arr[right]) {
            return right;
        }
        if (num == arr[left]) {
            return left;
        }
        int resultIndex = -1;
        while (left <= right) {
            int midIndex = left + (right - left) / 2;
            int midNum = arr[midIndex];
            if (num > midNum) {
                left = midIndex + 1;
            } else if (num < midNum) {
                right = midIndex - 1;
            } else {
                resultIndex = midIndex;
                break;
            }
        }
        return resultIndex;
    }

}
