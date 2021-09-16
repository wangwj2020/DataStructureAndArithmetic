package com.wwj.dataStructure.line.queue;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.dataStructure.line.queue
 * @ClassName: ArrayQueue
 * @Author: ASUS
 * @Description: 顺序队列
 * @Date: 2021/8/8 7:57
 * @Version: 1.0
 */
public class ArrayQueue<T> {
    private final T[] items;
    private final int capacity;
    private int header;
    private int tail;
    private int size;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        header = 0;
        tail = 0;
        size = 0;
        items = (T[]) new Object[capacity];
    }

    public boolean enqueue(T item) {
        if (needReNew()) {
            int size = tail - header;
            header = 0;
            tail = header + size;

            int index = 0;
            for (int i = header; i <= tail; i++) {
                items[index] = items[i];
                index++;
            }
        }
        if (isFull()) {
            return false;
        }
        items[tail] = item;
        tail++;
        size++;
        return true;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = items[header];
        header++;
        size--;
        return item;

    }

    private boolean isEmpty() {
        return tail == header;
    }

    private boolean isFull() {
        return header == 0 && tail == capacity;
    }

    private boolean needReNew() {
        return tail == capacity && header != 0;
    }

}
