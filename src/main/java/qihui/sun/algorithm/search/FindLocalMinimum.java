package qihui.sun.algorithm.search;

/**
 * 局部最小的前提是任何相邻的两个数不能相同,否则可能就要使用暴力遍历了
 */
public class FindLocalMinimum {
    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 5, 6, 3, 99, 11, 66, 46, 45, 78, 37, 14, 15, 16, 17, 18, 19, 20};
        findLocalMinimum(arr);
    }

    public static void findLocalMinimum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            System.out.println(arr[0]);
            return;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            System.out.println(arr[arr.length - 1]);
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int midIndex = left + ((right - left) >> 1);
            if (arr[midIndex] > arr[midIndex - 1]) {
                right = midIndex - 1;
            } else if (arr[midIndex] > arr[midIndex + 1]) {
                left = midIndex + 1;
            } else {
                System.out.println(arr[midIndex - 1] + "--" + arr[midIndex] + "--" + arr[midIndex + 1]);
                return;
            }
        }
    }

}
