package com.wwj.arithmetic.dynamicProgramming;

/**
 * 莱文斯坦距离
 * 求：把一个字符串变成另一个字符串，需要的最少编辑次数
 * * auth sherry
 * data created in 2021/10/19 9:47 上午
 */
public class LevenshteinDistance {
    private char[] c1;
    private char[] c2;
    private int c1Length;
    private int c2Length;
    private int[][] table;

    public LevenshteinDistance(char[] c1, char[] c2) {
        this.c1 = c1;
        this.c2 = c2;
        c1Length = c1.length;
        c2Length = c2.length;
        table = new int[c1Length][c2Length];
    }

    public int calDistance(int m, int n) {
        if (m == 0 && n == 0) {
            return table[m][n] = 0;
        } else if (m == 0) {
            return table[m][n] = calDistance(0, n - 1) + 1;
        } else if (n == 0) {
            return table[m][n] = calDistance(m - 1, 0) + 1;
        }

        if (c1[m] == c2[n]) {
            return table[m][n] = min(calDistance(m - 1, n) + 1, calDistance(m, n - 1) + 1, calDistance(m - 1, n - 1));
        } else {
            return table[m][n] = min(calDistance(m - 1, n) + 1, calDistance(m, n - 1) + 1, calDistance(m - 1, n - 1) + 1);
        }
    }

    private int min(int x, int y, int z) {
        int min = Math.min(x, y);
        return Math.min(min, z);
    }
}
