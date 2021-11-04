package com.wwj.stage2.dataStructure.linked;

import lombok.Data;

/**
 * 环形链表
 * 线性表
 * auth sherry
 * data created in 2021/11/3 8:19 下午
 */
public class CycleLinked<T> {
    private final Node<T> header;
    private final int capacity;
    private int size;

    public CycleLinked(int v) {
        if (v <= 1) {
            throw new RuntimeException("capacity must be more than 1");
        }
        header = new Node<>(null);
        header.setHeader(true);
        this.capacity = v;
        size = 0;
    }

    /**
     * 向链表添加一个元素
     *
     * @param t 元素
     */
    public void add(T t) {
        Node<T> currentNode = new Node<>(t);
        ++size;
        if (header.nextIsNull()) {
            header.next = currentNode;
            return;
        }
        if (size > capacity) {
            throw new RuntimeException("linked is full");
        }
        Node<T> node = header;
        while (!node.nextIsNull()) {
            node = node.next;
        }
        if (size == capacity) {
            node.next = currentNode;
            currentNode.pre = node;
            currentNode.next = header;
            header.pre = currentNode;
        } else {
            node.next = currentNode;
            currentNode.pre = node;
        }
    }

    public void remove(T t) {
        Node<T> node = header;
        while (!node.next.isHeader && !node.nextIsNull()) {
            node = node.next;
            if (node.getT() == t) {
                Node<T> pre = node.getPre();
                Node<T> next = node.getNext();
                pre.next = next;
                next.pre = pre;
                --size;
            }
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = header;
        while (!node.next.isHeader && !node.nextIsNull()) {
            node = node.next;
            sb.append(node.getT().toString()).append(",");
        }
        return sb.toString();
    }

    @Data
    public static class Node<T> {
        protected Node<T> pre;
        protected Node<T> next;
        protected T t;
        protected boolean isHeader;

        public Node(T t) {
            this.t = t;
        }

        public boolean nextIsNull() {
            return next == null;
        }

    }
}
