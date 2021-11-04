package com.wwj.stage1.sort;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.arithmetic.sort
 * @ClassName: BubbleSort
 * @Author: ASUS
 * @Description: 快速排序
 * 时间复杂度 O(nlogn)、最好时间复杂度O(nlogn)、最坏时间复杂度O(n2)、平均时间复杂度O(nlogn)
 * 空间复杂度 O(1)
 * 原地排序:YES
 * 稳定排序:NO
 * @Date: 2021/8/8 12:38
 * @Version: 1.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 1, 3, 2};
        quickSort(ints, 0, ints.length - 1);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] ints, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partion(ints, start, end);
        quickSort(ints, start, index-1);
        quickSort(ints, index + 1, end);
    }

    // TODO O(n) 时间复杂度内求无序数组中的第 K 大元素

    //TODO 现在你有 10 个接口访问日志文件，每个日志文件大小约 300MB，每个文件里的日志都是按照时间戳从小到大排序的。你希望将这 10 个较小的日志文件，合并为 1 个日志文件，合并之后的日志仍然按照时间戳从小到大排列。如果处理上述排序任务的机器内存只有 1GB，你有什么好的解决思路，能“快速”地将这 10 个日志文件合并吗？

    private static int partion(int[] ints, int start, int end) {
        int target = ints[end];
        System.out.println("start = " + start + " end = " + end);
        int processIndex = start;
        for (int i = start; i < end; i++) {
            if (ints[i] < target) {
                swap(ints, processIndex, i);
                processIndex++;
            }
        }
        swap(ints, processIndex, end);
        return processIndex;
    }

    private static void swap(int[] ints, int a, int b) {
        int tmp = ints[b];
        ints[b] = ints[a];
        ints[a] = tmp;

    }

}
