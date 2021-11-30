package com.wwj.stage2.algorithm.search;

/**
 * 二分查找法
 * 及其高效的O(logn)
 * 适用前提：有序的数组数据
 * 适用场景：大量已排序的好的数据进行查找
 * 不适用场景：特别大的数据量（因为需要连续内容空间）
 * 特别小的数据量（小数据量循环查询的效率也不差，用二分法反而增加代码复杂度）
 * auth sherry
 * data created in 2021/11/30 9:37 上午
 */
public class BinarySearch {
    private int[] arr;
    private int len;

    public BinarySearch(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
    }

    /**
     * 查找数组中首个目标元素的下标
     *
     * @param val 目标元素
     * @return 目标元素的下标
     */
    public int searchFirstEquals(int val) {
        if (len == 0) {
            return -1;
        }
        int index = searchFirstEquals(0, len - 1, val);
        while (index > 0) {
            index--;
            if (arr[index] != val) {
                return index + 1;
            }
        }
        return index;
    }

    /**
     * 查找数组中最后以个目标元素的下标
     *
     * @param val 目标元素
     * @return 目标元素的下标
     */
    public int searchLastEquals(int val) {
        if (len == 0) {
            return -1;
        }
        int index = searchFirstEquals(0, len - 1, val);
        while (index < len - 1) {
            index++;
            if (arr[index] != val) {
                return index - 1;
            }
        }
        return index;
    }

    private int searchFirstEquals(int start, int end, int val) {
        if (start >= end) {
            if (arr[end] == val) {
                return end;
            }
            return -1;
        }
        int index = start + (end - start) / 2;
        int i = arr[index];
        if (i == val) {
            return index;
        } else if (i > val) {
            return searchFirstEquals(start, index, val);
        } else {
            return searchFirstEquals(index + 1, end, val);
        }
    }

}
