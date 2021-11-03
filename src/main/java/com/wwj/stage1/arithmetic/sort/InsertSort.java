package com.wwj.stage1.arithmetic.sort;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.arithmetic.sort
 * @ClassName: BubbleSort
 * @Author: ASUS
 * @Description: 插入排序
 * 时间复杂度 O(n2)、最好时间复杂度O(n)、最坏时间复杂度O(n2)、平均时间复杂度O(n2)
 * 空间复杂度 O(1)
 * 是原地排序
 * 是稳定排序
 * @Date: 2021/8/8 12:38
 * @Version: 1.0
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 1, 3, 2};
//        insertionSort(ints, ints.length);
        ints = insertSort(ints);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] insertSort(int[] ints) {
        int length = ints.length;
        if (length == 1) {
            return ints;
        }

        for (int i = 1; i < length; i++) {
            System.out.println("i=" + i);
            int value = ints[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (ints[j] > value) {
                    ints[j + 1] = ints[j];
                } else {
                    break;
                }
            }
            ints[j+1] = value;
        }
        return ints;
    }


    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
//            System.out.println("i=" + i);
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }
}
