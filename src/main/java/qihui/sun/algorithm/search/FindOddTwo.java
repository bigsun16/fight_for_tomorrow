package qihui.sun.algorithm.search;

/**
 * 找到数组中只出现一次的两个数
 * 任何数与自身异或结果为0
 * 任何一个数与0异或结果不变
 * 1^1 = 0; 0^1 = 1; 0^0 = 0;
 * 1&1 = 1; 0&1 = 0; 0&0 = 0;
 */
public class FindOddTwo {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12};
        find(arr);
    }

    private static void find(int[] arr) {
        int res = 0;
        for (int num : arr) {
            res ^= num;
        }
        int rightOneBit = (~res + 1) & res;
        int oneNum = 0;
        for (int num : arr) {
            if ((num & rightOneBit) != 0) {
                oneNum ^= num;
            }
        }

        System.out.println(oneNum + "=========" + (oneNum ^ res));

    }
}
