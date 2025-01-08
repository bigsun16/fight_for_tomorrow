package qihui.sun.algorithm.search;

/**
 * 局部最小的前提是任何相邻的两个数不能相同,否则可能就要使用暴力遍历了
 */
public class FindLocalMinimum {
    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 5, 6, 3, 99, 11, 66, 44, 45, 7, 3, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(findLocalMinimum(arr));
    }

    public static Integer findLocalMinimum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int midIndex = left + (right - left) / 2;
            int midNum = arr[midIndex];
            if (midNum > arr[midIndex - 1]) {
                right = midIndex - 1;
            } else if (midNum > arr[midIndex + 1]) {
                left = midIndex + 1;
            } else {
                return midNum;
            }
        }
        return null;
    }

}
