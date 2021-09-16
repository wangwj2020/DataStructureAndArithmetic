package com.wwj.dataStructure.tree;

/**
 * 堆树
 * auth sherry
 * data created in 2021/9/16 4:50 下午
 */
public class Deap {

    private Node[] nodes;

    private int length;

    public Deap(int capacity) {
        nodes = new Node[capacity];
        this.length = 0;
    }

    public void insert(int val) {
        Node newNode = new Node(val, null, null);
        int parentIndex = length / 2;
        Node parentNode = nodes[parentIndex];
        if (parentNode == null) {
            nodes[parentIndex] = newNode;
            return;
        }
        nodes[length++] = newNode;

        Node p = parentNode;
        Node current = null;
        int pIndex = parentIndex;
        while (p != null && p.value < val) {
            current = p;
            pIndex = parentIndex / 2;
            p = nodes[pIndex];
        }
        newNode.value = current.value;
        current.value = val;

    }

    static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}
