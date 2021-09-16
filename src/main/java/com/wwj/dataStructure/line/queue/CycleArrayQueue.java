package com.wwj.dataStructure.line.queue;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.dataStructure.line.queue
 * @ClassName: ArrayQueue
 * @Author: ASUS
 * @Description: 循环顺序队列
 * @Date: 2021/8/8 7:57
 * @Version: 1.0
 */
public class CycleArrayQueue<T> {
    private final T[] items;
    private final int capacity;
    private int header;
    private int tail;
    private int size;

    public CycleArrayQueue(int capacity) {
        this.capacity = capacity;
        header = 0;
        tail = 0;
        size = 0;
        items = (T[]) new Object[capacity];
    }

    public boolean enqueue(T item) {
        if (startNewCycle()) {
            tail = 0;
        }
        if (isFull()) {
            return false;
        }
        items[tail] = item;
        size++;
        tail++;
        return true;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        if (header == capacity) {
            header = 0;
        }
        T item = items[header];
        header++;
        size--;
        return item;

    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean startNewCycle() {
        return !isFull() && tail == capacity;
    }

}
