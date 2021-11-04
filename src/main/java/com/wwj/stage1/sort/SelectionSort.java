package com.wwj.stage1.sort;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.arithmetic.sort
 * @ClassName: BubbleSort
 * @Author: ASUS
 * @Description: 选择排序
 * 时间复杂度 O(n2)、最好时间复杂度O(n2)、最坏时间复杂度O(n2)、平均时间复杂度O(n2)
 * 空间复杂度 O(1)
 * 非原地排序
 * 是稳定排序
 * @Date: 2021/8/8 12:38
 * @Version: 1.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 1, 3, 2};
        ints = selectionSort(ints);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] selectionSort(int[] ints) {
        int length = ints.length;
        for (int i = 0; i < length; i++) {
            int index = i;
            for (int m = i + 1; m < length; m++) {
                int a = ints[index];
                int b = ints[m];
                if (b < a) {
                    index = m;
                }
            }
            int tmp = ints[i];
            ints[i] = ints[index];
            ints[index] = tmp;
        }
        return ints;
    }


}
