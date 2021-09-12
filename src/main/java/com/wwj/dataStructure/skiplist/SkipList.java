package com.wwj.dataStructure.skiplist;

import java.util.Random;

/**
 * 跳表：
 * 跳表中存储的为整数，无重复
 *
 * 时间复杂度：logn
 * 空间复杂度：n
 */
public class SkipList {

    private static final int MAX_LEVEL = 16;

    private int LEVEL_COUNT = 1;

    private final Node head = new Node(MAX_LEVEL);

    public Node find(int val) {
        Node p = head;
        for (int i = LEVEL_COUNT - 1; i >= 0; i--) {
            if (p.forwards[i] != null && p.forwards[i].data < val) {
                p = p.forwards[i];
            }
        }
        if (p.forwards[0] != null && p.forwards[0].data == val) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int val) {
        int level = head.forwards[0] == null ? 1 : randomLevel();
        if (level > LEVEL_COUNT) {
            level = ++LEVEL_COUNT;
        }
        Node newNode = new Node(level);
        newNode.data = val;

        Node p = head;
        //从上往下进行查询
        for (int i = LEVEL_COUNT - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < val) {
                p = p.forwards[i];
            }

            if (i < level) {
                Node next = p.forwards[i];
                if (next == null) {
                    p.forwards[i] = newNode;
                } else {
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }

    }

    public void delete(int val) {
        Node[] update = new Node[LEVEL_COUNT];
        Node p = head;
        for (int i = LEVEL_COUNT - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < val) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0].data == val) {
            for (int i = LEVEL_COUNT - 1; i >= 0; i--) {
                if (update[i].forwards[i].data == val) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

    }

    /**
     * 打印所有数据
     */
    public void printAll_beautiful() {
        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print((d[i] != null ? d[i].getData() : null) + ":" + i + "-------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
    }

    /**
     * 对于随机层进行跳表更新
     *
     * @return 需要进行索引更新的层
     */
    private int randomLevel() {
        Random random = new Random();
        int level = 1;
        for (int i = 0; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                level += 1;
            }
        }
        return level;
    }

    public static class Node {

        private int data;

        private final Node[] forwards;

        public Node(int level) {
            this.forwards = new Node[level];
        }

        public int getData() {
            return data;
        }
    }
}
