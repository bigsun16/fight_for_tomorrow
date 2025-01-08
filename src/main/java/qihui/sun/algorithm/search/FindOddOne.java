package qihui.sun.algorithm.search;

/**
 * 找出数组中只出现奇数次的那个数字
 */
public class FindOddOne {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13,13,6};
        System.out.println(findOddOne(arr));
        System.out.println(findOddOne2(arr));
    }

    private static int findOddOne2(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }

    private static int findOddOne(int[] arr) {
        int res = 0;
        for (int j : arr) {
            res ^= j;
        }
        return res;
    }
}
