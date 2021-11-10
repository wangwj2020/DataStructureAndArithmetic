package com.wwj.stage2.algorithm.sort;

/**
 * auth sherry
 * data created in 2021/11/9 8:05 下午
 */
public class ArraySort {

    /**
     * 冒泡排序
     *
     * @param arr 数组
     * @param len 数组长度
     */
    public static int[] bubbleSort(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            for (int t = 0; t + 1 < len - i; t++) {
                if (arr[t] > arr[t + 1]) {
                    swap(arr, t, t + 1);
                }
            }
        }
        return arr;
    }

    /**
     * 插入排序
     *
     * @param arr 数组
     * @param len 数组长度
     * @return 排序后数组
     */
    public static int[] insertionSort(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            for (int t = i; t - 1 >= 0; t--) {
                if (arr[t - 1] > arr[t]) {
                    swap(arr, t, t - 1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序，每次选择最小的排到左边
     *
     * @param arr 数组
     * @param len 数组长度
     * @return 排序后的数组
     */
    public static int[] selectionSort(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int t = i; t < len; t++) {
                if (min > arr[t]) {
                    min = arr[t];
                    minIndex = t;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
