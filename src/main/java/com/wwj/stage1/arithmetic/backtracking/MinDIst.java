package com.wwj.stage1.arithmetic.backtracking;

/**
 * 最小路径
 * auth sherry
 * data created in 2021/10/17 6:31 下午
 */
public class MinDIst {
    public int minDist = Integer.MAX_VALUE;


    public void minDistCal(int[][] table, int dist, int row, int column, int n) {
        if (row == n - 1 && column == n - 1) {
            if (minDist > dist) {
                minDist = dist;
            }
        }
        //向下移动
        if (row + 1 < n) {
            minDistCal(table, dist + table[row + 1][column], row + 1, column, n);
        }
        //向右移动
        if (column + 1 < n) {
            minDistCal(table, dist + table[row][column + 1], row, column + 1, n);
        }
    }
}
