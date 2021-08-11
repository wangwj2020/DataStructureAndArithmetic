package com.wwj.dataStructure.linked;

import lombok.Data;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.链表.单链表
 * @ClassName: DoubleLinked
 * @Author: ASUS
 * @Description: lru单链表
 * @Date: 2021/8/6 16:54
 * @Version: 1.0
 */
@Data
public class LruSingleLinked<T> {
    private Node<T> header;

    private int size = 0;

    private int capacity;

    public LruSingleLinked(int capacity) {
        this.capacity = capacity;
        header = new Node<>(null);
    }

    /**
     * 链表添加一个元素
     *
     * @param value 值
     */
    public void addHeader(T value) {
        if (size < capacity) {
            Node<T> node = new Node<>(value);
            Node<T> current = header;
            Node<T> next = current.next;
            current.next = node;
            node.next = next;
            size++;
        } else {
            removeTail();
            size--;
            addHeader(value);
        }
    }

    public void removeTail() {
        if (header.next == null) {
            return;
        }

        Node<T> current = header;
        Node<T> pre = null;

        if (current.next != null) {
            pre = current;
            current = current.next;
        }
        pre.next = null;
        current = null;
    }

    /**
     * 查找指定value的index
     *
     * @param value 值
     * @return int 0表示原本不存在，非0表示原本在链表中的位置
     */
    public int find(T value) {
        int index = removeTargetValue(value);
        addHeader(value);
        return index;
    }

    private int removeTargetValue(T value) {
        Node<T> node = header.next;
        Node<T> pre = header;

        int index = 1;
        while (node != null) {
            T val = node.value;
            if (val.equals(value)) {
                pre.next = node.next;
                size--;
                return index;
            }
            pre = node;
            node = node.next;
            index++;
        }
        return 0;
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
        checkIndex(index);

        Node<T> node = header;
        Node<T> pre = null;
        for (int i = 0; i < index; i++) {
            pre = node;
            node = node.next;
        }
        pre.next = node.getNext();
        size--;
    }

    private void checkIndex(int index) {
        if (size - 1 < index) {
            throw new IllegalArgumentException("out of bound");
        }
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
