package com.wwj.arithmetic.reduce;

/**
 * 数组有序度算法
 * 思想：分治思想
 * <p>
 * auth sherry
 * data created in 2021/10/12 10:33 上午
 */
public class DegreeOrder {

    private int num = 0; // 全局变量或者成员变量

    public int count(int[] a) {
        num = 0;
        int n = a.length;
        mergeSortCounting(a, 0, n - 1);
        return num;
    }

    private void mergeSortCounting(int[] a, int p, int q) {
        if (p >= q) return;
        int m = (p + q) / 2;
        mergeSortCounting(a, p, m);
        mergeSortCounting(a, m + 1, q);
        merge(a, p, m, q);
    }

    private void merge(int[] a, int p, int m, int q) {
        int i = p, j = m + 1, k = 0;
        int[] tmp = new int[q - p + 1];
        while (i <= m && j <= q) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                num += (m - i + 1); // 统计p-q之间，比a[j]大的元素个数
                tmp[k++] = a[j++];
            }
        }
        while (i <= m) { // 处理剩下的
            tmp[k++] = a[i++];
        }
        while (j <= q) { // 处理剩下的
            tmp[k++] = a[j++];
        }
        for (i = 0; i <= q - p; ++i) { // 从tmp拷贝回a
            a[p + i] = tmp[i];
        }
    }

}
