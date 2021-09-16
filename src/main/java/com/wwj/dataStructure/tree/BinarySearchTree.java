package com.wwj.dataStructure.tree;

/**
 * 二分查找树
 * 节点的左边都比当前的节点数值小，节点的右边都比当前节点的数值大
 * 增 删 查时间复杂度：O(logn)
 * 排序时间复杂度：O(n)
 * auth sherry
 * data created in 2021/9/15 4:08 下午
 */
public class BinarySearchTree {
    private Node root;

    public Node find(int val) {
        if (root == null) {
            return null;
        }
        Node tmp = root;
        do {
            if (tmp.value == val) {
                return tmp;
            } else if (val < tmp.value) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        } while (tmp != null);
        return null;
    }

    public void remove(int val) {
        if (root == null) {
            return;
        }
        Node node = root;
        Node preNode = null;

        while (node != null && node.value != val) {
            preNode = node;
            if (val > node.value) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (node == null) {
            return;
        }

        //当前节点有两个节点
        if (node.left == null && node.right == null) {
            Node minNode = node;
            Node preMinNode = node;
            while (node.left != null) {
                preMinNode = minNode;
                minNode = minNode.left;
            }
            node.value = minNode.value;
            preMinNode.left = null;
        }

        //当前节点只有一个节点或是叶子节点
        Node child;
        if (node.left != null) {
            child = node.left;
        } else if (node.right != null) {
            child = node.right;
        } else {
            child = null;
        }

        //根节点
        if (preNode == null) {
            root = child;
        } else if (preNode.left == node) {
            preNode.left = child;
        } else {
            preNode.right = child;
        }

    }

    public void insert(int value) {
        Node newNode = new Node(value, null, null);
        if (root == null) {
            root = newNode;
        } else {
            Node parentNode = findNodeParent(root, value);
            if (value < parentNode.value) {
                parentNode.left = newNode;
            } else {
                parentNode.right = newNode;
            }
        }
    }

    /**
     * 中序排序
     *
     * @return 排序后的string
     */
    public String middleSort() {
        StringBuilder sb = new StringBuilder();
        middleSort(root, sb);
        return sb.toString();
    }

    private void middleSort(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        middleSort(node.left, sb);
        System.out.println(node.value);
        sb.append(node.value).append(",");
        middleSort(node.right, sb);
    }

    private Node findNodeParent(Node node, int value) {
        Node tmp = node;
        Node pre = null;
        while (tmp != null) {
            pre = tmp;
            if (value < tmp.value) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return pre;
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return this.value;
        }

    }
}
