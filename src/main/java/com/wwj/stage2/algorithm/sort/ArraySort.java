package com.wwj.stage2.algorithm.sort;

/**
 * auth sherry
 * data created in 2021/11/9 8:05 下午
 */
public class ArraySort {

    /**
     * 冒泡排序
     * O(n2)
     * 原地排序
     * 稳定排序
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
     * O(n2)
     * 原地排序
     * 稳定排序
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
     * O(n2)
     * 原地排序
     * 稳定排序
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

    /**
     * 归并排序
     * 非原地排序
     * 稳定排序
     * @param arr 数组
     * @param len 数组长度
     * @return 排序后的数组
     */
    public static int[] merger_sort(int[] arr, int len) {
        return sort(arr, 0, len - 1);
    }

    private static int[] sort(int[] arr, int start, int end) {
        int middle = start + ((end - start) / 2);
        if (start >= end) {
            return arr;
        }
        sort(arr, start, middle);
        sort(arr, middle + 1, end);
        merger(arr, start, middle, end);
        return arr;
    }

    private static void merger(int[] arr, int start, int middle, int end) {
        int[] newArr = new int[end - start + 1];
        int arrIndex = 0;
        int leftIndex = start;
        int rightIndex = middle + 1;
        while (leftIndex <= middle && rightIndex <= end) {

            if (arr[leftIndex] > arr[rightIndex]) {
                newArr[arrIndex++] = arr[rightIndex];
                rightIndex++;
            } else {
                newArr[arrIndex++] = arr[leftIndex];
                leftIndex++;
            }
        }

        if (leftIndex <= middle) {
            for (int i = leftIndex; i <= middle; i++) {
                newArr[arrIndex++] = arr[i];
            }
        }

        if (rightIndex <= end) {
            for (int i = rightIndex; i <= end; i++) {
                newArr[arrIndex++] = arr[i];
            }
        }

        if (end + 1 - start >= 0) System.arraycopy(newArr, 0, arr, start, end + 1 - start);
    }


    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static String arr2Str(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int s : arr) {
            sb.append(s).append(",");
        }
        return sb.toString();
    }

}
