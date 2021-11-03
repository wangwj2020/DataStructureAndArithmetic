package com.wwj.stage1.dataStructure.line.queue;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.dataStructure.line.queue
 * @ClassName: ArrayQueue
 * @Author: ASUS
 * @Description: 顺序队列
 * @Date: 2021/8/8 7:57
 * @Version: 1.0
 */
public class LinkedQueue<T> {
    private Node<T> header;
    private Node<T> tail;
    private int size;

    public LinkedQueue() {
        header = new Node<>();
        tail = new Node<>();
        header.next = tail;
        tail.pre = header;
        size = 0;
    }

    public void enqueue(T item) {
        Node<T> firstNode = header.next;
        Node<T> node = new Node<>(item);
        header.next = node;
        node.pre = header;
        node.next = firstNode;
        firstNode.pre = node;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node<T> firstNode = tail.pre;
        Node<T> seconderNode = firstNode.pre;
        seconderNode.next = tail;
        tail.pre = seconderNode;
        size--;
        return firstNode.value;
    }

    private boolean isEmpty() {
        return header.next == tail && tail.pre == header;
    }

    static class Node<T> {
        private T value;
        private Node<T> pre;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node() {
        }
    }

}
