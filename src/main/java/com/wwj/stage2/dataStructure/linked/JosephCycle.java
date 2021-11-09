package com.wwj.stage2.dataStructure.linked;

import lombok.Data;

import java.util.Objects;

/**
 * 约瑟夫问题
 * auth sherry
 * data created in 2021/11/4 6:00 下午
 */
public class JosephCycle<T> {
    private final JosephCycle.Node<T> header;
    private final JosephCycle.Node<T> tail;
    private final int capacity;
    private int size;

    public JosephCycle(int v) {
        if (v <= 1) {
            throw new RuntimeException("capacity must be more than 1");
        }
        header = new JosephCycle.Node<>(null);
        tail = new JosephCycle.Node<>(null);
        this.capacity = v;
        size = 0;
    }

    /**
     * 向链表添加一个元素
     *
     * @param t 元素
     */
    public void add(T t) {
        JosephCycle.Node<T> currentNode = new JosephCycle.Node<>(t);
        if (header.nextIsNull()) {
            header.next = currentNode;
            currentNode.pre = header;
            currentNode.next = tail;
            tail.pre = currentNode;
            ++size;
            return;
        }
        if (size > capacity) {
            throw new RuntimeException("linked is full");
        }
        JosephCycle.Node<T> tailPre = tail.pre;
        tailPre.next = currentNode;
        currentNode.pre = tailPre;
        currentNode.next = tail;
        tail.pre = currentNode;
        ++size;
    }

    /**
     * 报数到i的kill
     *
     * @param i 死亡数字
     * @return 最后剩下的
     */
    public String kill(int i) {
        if (size <= 0) {
            return "empty";
        }
        JosephCycle.Node<T> node = header;
        int count = 0;
        while (size >= i) {
            node = node.next;
            if (isTail(node)) {
                node = header;
                continue;
            }
            if (isHeader(node)) {
                continue;
            }

            ++count;
            if (count == i) {
                JosephCycle.Node<T> pre = node.getPre();
                JosephCycle.Node<T> next = node.getNext();
                pre.next = next;
                next.pre = pre;
                count = 0;
                --size;
            }
        }
        return print();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        JosephCycle.Node<T> node = header;
        while (!isTail(node.next)) {
            node = node.next;
            sb.append(node.getT().toString()).append(",");
        }
        return sb.toString();
    }

    private boolean isHeader(Node<T> node) {
        return Objects.equals(node, header);
    }

    private boolean isTail(Node<T> node) {
        return Objects.equals(node, tail);
    }

    @Data
    public static class Node<T> {
        private JosephCycle.Node<T> pre;
        private JosephCycle.Node<T> next;
        private T t;

        public Node(T t) {
            this.t = t;
        }

        public boolean nextIsNull() {
            return next == null;
        }

    }
}
