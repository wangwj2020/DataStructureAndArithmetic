package com.wwj.dataStructure.stack;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.dataStructure.linked
 * @ClassName: ArrayStack
 * @Author: ASUS
 * @Description: 顺序栈
 * @Date: 2021/8/7 6:53
 * @Version: 1.0
 */
public class ArrayStack<T> {

    T[] array;
    int capacity;
    int size;

    public ArrayStack(int count) {
        this.capacity = count;
        size = 0;
        array = (T[]) new Object[capacity];
    }

    public int push(T value) {
        pushCheck();
        array[size] = value;
        size++;
        return size - 1;
    }

    public T pop() {
        if (size == 0) {
            return null;
        }
        size--;
        return array[size];
    }

    public T getTop() {
        if (size==0) {
            return null;
        }
        return array[size-1];
    }

    private void pushCheck() {
        if (size >= capacity) {
            throw new IllegalArgumentException("out of bound");
        }
    }
}
