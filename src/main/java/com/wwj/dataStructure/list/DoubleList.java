package com.wwj.dataStructure.list;

import lombok.Data;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.链表.单链表
 * @ClassName: DoubleLinked
 * @Author: ASUS
 * @Description: 双链表
 * @Date: 2021/8/6 16:54
 * @Version: 1.0
 */
@Data
public class DoubleList<T> {
    private Node<T> header = new Node(null);
    private int size;

    /**
     * 链表添加一个元素
     *
     * @param value 值
     */
    public void add(T value) {
        if (header.next == null) {
            header.next = new Node(value);
        } else {
            Node<T> node = header;
            Node<T> next = node.getNext();
            while (next != null) {
                node = next;
                next = node.getNext();
            }
            node.next = new Node(value);
            node.next.pre = node;
        }
        size++;
    }

    /**
     * 从链表中获取一个值
     *
     * @param index 索引
     * @return val
     */
    public T get(int index) {
        checkIndex(index);
        Node<T> node = header;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node.value;
    }

    /**
     * 从链表中删除一个值
     *
     * @param index 所有
     */
    public void remove(int index) {
        checkIndex(index);

        Node<T> node = header.next;
        Node<T> pre = header;

        for (int i = 0; i < index; i++) {
            pre = node;
            node = node.next;
        }
        pre.next = node.getNext();
        if (node.getNext() != null) {
            node.getNext().pre = pre;
        }

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
        while (node != null) {
            sb.append(node.getValue()).append(",");
            node = node.getNext();
        }
        return sb.toString();
    }

    @Data
    static class Node<T> {
        private Node<T> next;
        private Node<T> pre;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        private boolean hasNext() {
            return next != null;
        }
    }
}
