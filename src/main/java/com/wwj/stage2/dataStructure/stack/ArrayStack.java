package com.wwj.stage2.dataStructure.stack;

import lombok.Data;

/**
 * 顺序栈
 * auth sherry
 * data created in 2021/11/8 11:54 下午
 */
@Data
public class ArrayStack {
    private final int capacity;
    private int size;
    private final String[] stacks;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stacks = new String[capacity];
    }

    public boolean push(String str) {
        if (size >= capacity) {
            return false;
        }
        stacks[size] = str;
        ++size;
        return true;
    }

    public String pop() {
        if (size <= 0) {
            throw new RuntimeException("stack is empty");
        }
        String stack = stacks[size - 1];
        stacks[size - 1] = null;
        --size;
        return stack;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
