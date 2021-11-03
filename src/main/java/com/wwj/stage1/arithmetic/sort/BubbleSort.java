package com.wwj.stage1.arithmetic.sort;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.arithmetic.sort
 * @ClassName: BubbleSort
 * @Author: ASUS
 * @Description: 冒泡排序
 * 时间复杂度 O(n2)、最好时间复杂度O(n)、最坏时间复杂度O(n2)、平均时间复杂度O(n2)
 * 空间复杂度 O(1)
 * 是原地排序
 * 是稳定排序
 *
 * @Date: 2021/8/8 12:38
 * @Version: 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] ints = {3, 5, 4, 1, 2, 6};
        int[] sort = bubbleSort(ints);
        for (int i : sort) {
            System.out.println(i);
        }
    }

    public static int[] bubbleSort(int[] ints) {
        int length = ints.length;
        int count = 0;
        for (int m = 0; m < length; m++) {
            boolean switchFlag = false;
            System.out.println("执行次数：" + count++);
            for (int i = 0; i < length - 1; i++) {
                int a = ints[i];
                int b = ints[i + 1];
                if (a > b) {
                    switchInt(ints, i);
                    switchFlag = true;
                }
            }
            if (!switchFlag) {
                return ints;
            }
        }
        return ints;
    }

    private static void switchInt(int[] ints, int i) {
        int tmp = ints[i];
        ints[i] = ints[i + 1];
        ints[i + 1] = tmp;
    }
}
