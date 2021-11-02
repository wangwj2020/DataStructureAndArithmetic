package com.wwj.dataStructure.tree;

/**
 * 堆树(小顶堆)
 * 特性：完全二叉树
 * <p>
 * auth sherry
 * data created in 2021/9/16 4:50 下午
 */
public class MinHeap {
    private int[] heap;
    private int capacity;
    private int count;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        //0位不存数据，从index 1开始存数据
        this.heap = new int[capacity + 1];
        count = 0;
    }

    /**
     * 添加一个数据
     * 时间复杂度：O(logn)
     *
     * @param v int
     */
    public void add(int v) {
        if (count >= capacity) {
            return;
        }
        int currentIndex = ++count;
        heap[currentIndex] = v;
        while (currentIndex != 0 && heap[currentIndex / 2] > heap[currentIndex]) {
            swap(heap, currentIndex / 2, currentIndex);
            currentIndex = currentIndex / 2;
        }
    }

    /**
     * 删除堆顶元素
     * 时间复杂度：O(logn)
     */
    public void removeMin() {
        int index = 1;
        heap[index] = heap[count];
        heap[count] = 0;
        count--;

        while (2 * index < count && 2 * index + 1 < count) {
            int maxPos = index;
            if (heap[2 * index] < heap[index]) {
                maxPos = 2 * index;
            }
            if (heap[2 * index + 1] < heap[maxPos]) {
                maxPos = 2 * index + 1;
            }
            swap(heap, index, maxPos);
            index = maxPos;
        }
    }

    public void sort() {
        // TODO: 2021/10/31
    }

    private void swap(int[] ints, int idx1, int idx2) {
        int idx1Int = ints[idx1];
        ints[idx1] = ints[idx2];
        ints[idx2] = idx1Int;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i : heap) {
            sb.append(i).append(",");
        }
        return sb.toString();
    }
}
