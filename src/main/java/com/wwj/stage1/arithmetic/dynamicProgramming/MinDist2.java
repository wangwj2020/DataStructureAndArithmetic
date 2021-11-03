package com.wwj.stage1.arithmetic.dynamicProgramming;

/**
 * 最短路径
 * 动态规划：状态转移方程法
 * auth sherry
 * data created in 2021/10/17 11:18 上午
 */
public class MinDist2 {
    private int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};

    private int n = 4;

    private int[][] mem = new int[n][n];

    public int minDisCal(int row, int column) {
        if (row == 0 && column == 0) {
            return matrix[0][0];
        }
        if (mem[row][column] > 0) {
            return mem[row][column];
        }
        //上一个·
        int upInt = Integer.MAX_VALUE;
        if (row - 1 >= 0) {
            upInt = minDisCal(row - 1, column);
        }
        //左一个
        int leftInt = Integer.MAX_VALUE;
        if (column - 1 >= 0) {
            leftInt = minDisCal(row, column - 1);
        }
        int currentMinDist = Math.min(upInt, leftInt) + matrix[row][column];
        mem[row][column] = currentMinDist;
        return currentMinDist;
    }

}
