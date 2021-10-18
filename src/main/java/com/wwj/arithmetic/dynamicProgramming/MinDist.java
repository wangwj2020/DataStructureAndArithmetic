package com.wwj.arithmetic.dynamicProgramming;

/**
 * 最短路径
 * 动态规划：状态转移表法
 * auth sherry
 * data created in 2021/10/17 11:18 上午
 */
public class MinDist {
    public int[][] status;

    public void minDisCal(int[][] table, int n) {
        this.status = new int[n][n];
        //首行循环
        int sum = 0;
        for (int c = 0; c < n; c++) {
            sum += table[0][c];
            status[0][c] = sum;
        }
        //首列循环
        sum = 0;
        for (int r = 0; r < n; r++) {
            sum += table[r][0];
            status[r][0] = sum;
        }

        sum = 0;
        for (int row = 1; row < n; row++) {
            for (int column = 1; column < n; column++) {
                status[row][column] = table[row][column] + Math.min(status[row - 1][column], status[row][column - 1]);
            }
        }
    }

    public void print() {
        for (int row = 0; row < status.length; row++) {
            int[] rowArr = status[row];
            for (int column = 0; column < rowArr.length; column++) {
                System.out.println("第" + row + "行,第" + column + "列:" + rowArr[column]);
            }
        }
    }
}
