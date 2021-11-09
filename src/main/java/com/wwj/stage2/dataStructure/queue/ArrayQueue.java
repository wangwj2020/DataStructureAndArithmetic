package com.wwj.stage2.dataStructure.queue;

/**
 * 顺序队列
 * auth sherry
 * data created in 2021/11/9 12:08 上午
 */
public class ArrayQueue {
    private final String[] queue;
    private final int capacity;
    private int size;
    private int header;
    private int tail;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.header = 0;
        this.tail = -1;
    }

    public boolean enQueue(String str) {
        if (isFull()) {
            return false;
        }
        if (tail >= capacity - 1) {
            carryData();
        }
        ++tail;
        queue[tail] = str;
        ++size;
        return true;
    }

    public String deQueue() {
        if (size == 0) {
            throw new RuntimeException("queue is empty");
        }
        String str = queue[this.header];
        queue[this.header] = null;
        ++header;
        --size;
        return str;
    }

    private void carryData() {
        if (isFull()) {
            return;
        }
        for (int i = 0; i < capacity; i++) {
            if (header > tail) {
                break;
            }
            queue[i] = queue[header++];
        }
        header = 0;
        tail = size - 1;
    }

    private boolean isFull() {
        return size == capacity;
    }
}
