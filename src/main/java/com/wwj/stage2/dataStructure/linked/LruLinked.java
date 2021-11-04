package com.wwj.stage2.dataStructure.linked;

import lombok.Data;

import java.util.Objects;

/**
 * 环形链表
 * 线性表
 * auth sherry
 * data created in 2021/11/3 8:19 下午
 */
public class LruLinked<T> {
    private final Node<T> header;
    private final int capacity;
    private int size;

    public LruLinked(int v) {
        if (v <= 1) {
            throw new RuntimeException("capacity must be more than 1");
        }
        header = new Node<T>(null);
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
        ++size;
        Node<T> currentNode = new Node<>(t);
        if (size == capacity) {
            insertAfterHeader(currentNode);
            Node<T> node = header;
            while (node.next != null && !node.next.isHeader()) {
                node = node.next;
            }
            node.next = header;
            header.pre = node;
        } else if (size > capacity) {
            remoLastNode();
            insertAfterHeader(currentNode);
        } else {
            insertAfterHeader(currentNode);
        }
    }

    public void remove(T t) {
        Node<T> node = header.next;
        while (node != null && !node.isHeader) {
            if (Objects.equals(node.getT(), t)) {
                Node<T> next = node.next;
                Node<T> pre = node.pre;
                pre.next = next;
                next.pre = pre;
                --size;
            }
            node = node.next;
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = header.next;
        while (node != null && !node.isHeader) {
            sb.append(node.getT().toString()).append(",");
            node = node.next;
        }
        return sb.toString();
    }

    private void insertAfterHeader(Node<T> node) {
        Node<T> headerNext = header.next;
        header.next = node;
        node.pre = header;
        node.next = headerNext;
        if (headerNext != null) {
            headerNext.pre = node;
        }
    }

    private void remoLastNode() {
        Node<T> pre = header.pre;
        pre.pre.next = header;
        header.pre = pre.pre;
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
