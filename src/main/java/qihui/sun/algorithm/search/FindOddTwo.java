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
        find2(arr);
    }

    private static void find2(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        int num1 = 0;
        int oneBitOfRight = (~result + 1) & result;
        for (int num : arr) {
            if ((num & oneBitOfRight) != 0) {
                num1 ^= num;
            }
        }
        System.out.println(num1 + "-----" + (result ^ num1));
    }

    private static void find(int[] arr) {
        int xorResult = 0;
        for (int j : arr) {
            xorResult ^= j;
        }
        int num1 = 0;
        // 找到最右边的1位
        int rightOne = xorResult & (~xorResult + 1);
        for (int j : arr) {
            if ((j & rightOne) == 0) {
                num1 ^= j;
            }
        }
        System.out.println(num1 + "======" + (num1 ^ xorResult));
    }
}
