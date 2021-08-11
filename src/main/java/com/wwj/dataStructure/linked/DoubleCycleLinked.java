package com.wwj.dataStructure.linked;

import lombok.Data;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.dataStructure
 * @ClassName: DoubleCycleLinked
 * @Author: ASUS
 * @Description: 双向循环链表
 * @Date: 2021/8/7 4:44
 * @Version: 1.0
 */
public class DoubleCycleLinked<T> {
    private Node<T> header;
    private Node<T> tail;
    private int size;

    public DoubleCycleLinked() {
        header = new Node<>();
        tail = new Node<>();
        header.next = tail;
        tail.pre = header;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        Node<T> current = header;
        if (current.next != tail) {
            current = current.next;
        }
        current.next = node;
        node.pre = current;
        node.next = tail;
        size++;
    }

    public void remove(int index) {
        Node current = getIndexNode(index);
        Node pre = current.pre;
        Node next = current.next;
        pre.next = next;
        next.pre = pre;
        current = null;
    }

    public T get(int index) {
        Node<T> current = getIndexNode(index);
        return current.value;
    }

    private Node<T> getIndexNode(int index) {
        checkIndex(index);
        Node<T> current = header.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (size < index) {
            throw new IllegalArgumentException("out of bound");
        }
    }

    /**
     * 打印链表中所有的节点信息
     *
     * @return string
     */
    public String print() {
        Node<T> node = header.next;
        StringBuilder sb = new StringBuilder();
        while (node != tail) {
            sb.append(node.getValue()).append(",");
            node = node.getNext();
        }
        return sb.toString();
    }

    @Data
    static class Node<T> {
        private Node<T> pre;
        private T value;
        private Node<T> next;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }
    }
}
