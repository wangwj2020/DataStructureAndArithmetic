package com.wwj.stage1.backtracking;

/**
 * 求背包中可装物品重量最大值：
 * 物品不可分割
 * auth sherry
 * data created in 2021/10/13 5:43 下午
 */
public class Bag0_1 {
    //存储背包中物品总重量的最大值
    public int maxW = Integer.MIN_VALUE;


    // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
    // w背包重量；items表示每个物品的重量；n表示物品个数
    // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    public void f(int i, int cw, int[] items, int n, int w) {
        if (i == n || w == cw) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        f(i + 1, cw, items, n, w);
        if (cw + items[i] < w) {
            f(i + 1, cw + items[i], items, n, w);
        }
    }
}

