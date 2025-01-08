package qihui.sun.algorithm.sort.quick;

import qihui.sun.algorithm.sort.CheckSortIsOk;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 * 描述：给定一个数组，包含三种颜色：红、白、蓝。要求原地排序，使得所有红色元素都在左侧，白色在中间，蓝色在右侧
 * 思路：类似于归并排序的合并过程，使用三个指针分别指向数组的开始、中间和结束位置
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        int num = arr[10];
//        int num = 1;
        System.out.println(num);
        sort(arr, num);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int num) {
        int lIndex = 0;
        int rIndex = arr.length - 1;
        int index = 0;
        while (index <= rIndex) {
            if (arr[index] < num) {
                CheckSortIsOk.swap2(arr, lIndex++, index++);
            } else if (arr[index] == num) {
                index++;
            } else {
                if (index < rIndex) {
                    CheckSortIsOk.swap2(arr, index, rIndex--);
                } else {
                    break;
                }
            }
        }
    }

}
