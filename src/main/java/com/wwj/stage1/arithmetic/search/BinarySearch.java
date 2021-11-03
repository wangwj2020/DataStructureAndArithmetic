package com.wwj.stage1.arithmetic.search;

/**
 * 二分查找：指的是在一个有序且没有重复的数组中，查找某个指定的元素，并返回指定元素的位置，如果没有找到，则返回-1。
 * 适用场景：数据是数组结构且有序不重复。
 * 不适用场景：数据量过小，此时可用for循环
 * 数据量过大，时数组对内容有连续性要求，此时内存可能不够用
 * 时间复杂度：logn
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] intArray = {1, 3, 5, 66, 98, 200, 400, 3212};
        int i = binarySearch(intArray, 400);
        System.out.println(i);
    }

    public static int binarySearch(int[] intArray, int target) {
        int length = intArray.length;
        if (length == 0) {
            return -1;
        }

        return findTargetIndex(intArray, target, 0, length - 1);

    }

    private static int findTargetIndex(int[] intArray, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (intArray[mid] == target) {
            return mid;
        } else if (intArray[mid] > target) {
            return findTargetIndex(intArray, target, start, mid - 1);
        } else {
            return findTargetIndex(intArray, target, mid + 1, end);
        }

    }
}
