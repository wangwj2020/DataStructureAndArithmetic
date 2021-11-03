package com.wwj.stage1.dataStructure.tree;

import lombok.Data;

/**
 *
 *
 * auth sherry
 * data created in 2021/10/11 6:45 下午
 */
@Data
public class TrialTree {
    char note;
    TrialTree[] children;
    boolean isLeaf;

    public TrialTree(char note) {
        this.note = note;
        this.children = new TrialTree[26];
        this.isLeaf = false;
    }

    public void insert(String str) {
        TrialTree tmp = this;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            TrialTree[] children = tmp.children;
            TrialTree childTrialTree = children[index];
            if (childTrialTree == null) {
                children[index] = new TrialTree(note);
            }
            tmp = children[index];
        }
        tmp.isLeaf = true;
    }

    // 在Trie树中查找一个字符串
    public boolean find(String str) {
        TrialTree tmp = this;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            TrialTree[] children = tmp.children;
            TrialTree childTrialTree = children[index];
            if (childTrialTree == null) {
                return false;
            }
            tmp = childTrialTree;
        }
        return tmp.isLeaf;
    }

}
