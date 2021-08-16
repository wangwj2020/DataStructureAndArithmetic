package com.wwj.dataStructure.list;

import lombok.Data;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.链表.单链表
 * @ClassName: DoubleLinked
 * @Author: ASUS
 * @Description: 单链表
 * @Date: 2021/8/6 16:54
 * @Version: 1.0
 */
@Data
public class SingleList<T> {
    private Node<T> header;

    private int size;

    /**
     * 链表添加一个元素
     *
     * @param value 值
     */
    public void add(T value) {
        if (header == null) {
            header = new Node(value);
        } else {
            Node<T> next = header.getNext();
            Node<T> pre = header;
            while (next != null) {
                pre = next;
                next = next.getNext();
            }
            pre.next = new Node(value);
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
        if (size - 1 < index) {
            throw new IllegalArgumentException("out of bound");
        }
        Node<T> node = header;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    /**
     * 从链表中删除一个值
     *
     * @param index 所有
     * @return 成功失败
     */
    public void remove(int index) {
        if (size - 1 < index) {
            throw new IllegalArgumentException("out of bound");
        }

        Node<T> node = header;
        Node<T> pre = null;
        for (int i = 0; i < index; i++) {
            pre = node;
            node = node.next;
        }
        pre.next = node.getNext();
        size--;
    }

    /**
     * 打印链表中所有的节点信息
     *
     * @return string
     */
    public String print() {
        Node node = header;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.getValue()).append(",");
            node = node.getNext();
        }
        return sb.toString();
    }

    @Data
    class Node<T> {
        private Node next;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        private boolean hasNext() {
            return next != null;
        }
    }
}
