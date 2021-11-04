package com.wwj.stage1.backtracking;

/**
 * 莱文斯坦距离
 * 求：把一个字符串变成另一个字符串，需要的最少编辑次数
 * auth sherry
 * data created in 2021/10/18 7:34 下午
 */
public class LevenshteinDistance {
    public int minEditorCount = Integer.MAX_VALUE;

    private char[] c1;
    private char[] c2;
    private int c1Length;
    private int c2Length;

    public LevenshteinDistance(char[] c1, char[] c2) {
        this.c1 = c1;
        this.c2 = c2;
        c1Length = c1.length;
        c2Length = c2.length;
    }

    public void calDistance(int m, int n, int editorCount) {
        if (m == c1Length || n == c2Length) {
            if (m < c1Length) {
                editorCount += (c1Length - m);
            }
            if (n < c2Length) {
                editorCount += (c2Length - n);
            }
            if (minEditorCount > editorCount) {
                minEditorCount = editorCount;
            }
            return;
        }
        if (c1[m] == c2[n]) {
            calDistance(m + 1, n + 1, editorCount);
        } else {
            calDistance(m + 1, n, editorCount + 1);
            calDistance(m, n + 1, editorCount + 1);
            calDistance(m + 1, n + 1, editorCount + 1);
        }
    }
}
