package com.wwj.stage1.dataStructure.tree;

/**
 * 堆树
 * auth sherry
 * data created in 2021/9/16 4:50 下午
 */
public class Heap {

    private final int[] ints;
    private int count;
    private final int capacity;

    public Heap(int capacity) {
        ints = new int[capacity + 1];
        this.capacity = capacity;
        count = 0;
    }

    /**
     * 时间复杂度：O(nlogn)
     */
    public void sort() {
        //  2021/9/17 建堆
        buildHeap();
        //  2021/9/17 排序
        int size = count;
        while (size > 0) {
            swap(1, size--);
            heapify(ints, size, 1);
        }
    }

    /**
     * 时间复杂度：O(logn)
     */
    public void insert(int val) {
        if (count >= capacity) {
            return;
        }
        count++;
        ints[count] = val;

        int i = count;
        while (i != 0 && ints[i] < val) {
            swap(i / 2, count);
            i = i / 2;
        }
    }

    /**
     * 时间复杂度：O(logn)
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        ints[1] = ints[count];
        heapify(ints, count, 1);
    }

    private void buildHeap() {
        for (int i = count / 2; i >= 1; i--) {
            heapify(ints, count, i);
        }
    }

    private void heapify(int[] ints, int count, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= count && ints[i * 2] > ints[i]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= count && ints[i * 2 + 1] > ints[maxPos]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                return;
            }
            swap(i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int i, int count) {
        int tmp = ints[i];
        ints[i] = ints[count];
        ints[count] = tmp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : ints) {
            if (0 != i) {
                sb.append(i).append(",");
            }
        }
        return sb.toString();
    }
}
