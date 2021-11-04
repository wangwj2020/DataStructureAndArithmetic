package com.wwj.stage1.sort;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.arithmetic.sort
 * @ClassName: BubbleSort
 * @Author: ASUS
 * @Description: 归并排序
 * 时间复杂度 O(nlogn)、最好时间复杂度O(nlogn)、最坏时间复杂度O(nlogn)、平均时间复杂度O(nlogn)
 * 空间复杂度 O(n)
 * 原地排序:NO
 * 稳定排序:YES
 * @Date: 2021/8/8 12:38
 * @Version: 1.0
 */
public class MergerSort {

    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 1, 3, 2};
        mergerSort(ints, 0, ints.length - 1);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static void mergerSort(int[] ints, int start, int end) {
        System.out.println("start = " + start + " end = " + end);
        if (start >= end) {
            System.out.println("end ...");
            return;
        }
        int mid = (start + end) / 2;
        mergerSort(ints, start, mid);
        mergerSort(ints, mid + 1, end);
        merger(ints, start, mid, mid + 1, end);
    }

    private static void merger(int[] ints, int start, int mid, int midNext, int end) {
        int[] tmp = new int[end - start + 1];
        int m = start;
        int n = midNext;
        int k = 0;

        while (m <= mid && n <= end) {
            System.out.println("m = " + m + " n = " + n+" mid = "+mid);
            if (ints[m] <= ints[n]) {
                tmp[k++] = ints[m++];
            } else {
                tmp[k++] = ints[n++];
            }
            System.out.println("--------");
        }

        int begin = m;
        int over = mid;
        if (n <= end) {
            begin = n;
            over = end;
        }

        System.out.println("begin = " + begin + " over=" + over);
        while (begin <= over) {
            tmp[k++] = ints[begin++];
        }

        for (int i = 0; i < end - start + 1; i++) {
            ints[start + i] = tmp[i];
        }
    }


}
