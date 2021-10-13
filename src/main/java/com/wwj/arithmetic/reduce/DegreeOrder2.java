package com.wwj.arithmetic.reduce;

/**
 * 数组有序度算法
 * 思想：分治思想
 * <p>
 * auth sherry
 * data created in 2021/10/12 10:33 上午
 */
public class DegreeOrder2 {
    private int num = 0;

    public int count(int[] arr) {
        num = 0;
        mergerSorting(arr, 0, arr.length - 1);
        return num;
    }

    public void mergerSorting(int[] arr, int p, int q) {
        if (p >= q) return;
        int m = (p + q) / 2;
        mergerSorting(arr, p, m);
        mergerSorting(arr, m + 1, q);
        merger(arr, p, m, q);
    }

    private void merger(int[] arr, int p, int m, int q) {
        int i = p, j = m + 1, k = 0;
        int[] tmp = new int[q - p + 1];
        while (i <= m && j <= q) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                num += (m - i + 1); // 统计p-q之间，比a[j]大的元素个数
                tmp[k++] = arr[j++];
            }
        }
        while (i <= m) {
            tmp[k++] = arr[i++];
        }
        while (j <= q) {
            tmp[k++] = arr[j++];
        }

        for (i = 0; i <= q - p; ++i) { // 从tmp拷贝回a
            arr[p + i] = tmp[i];
        }
    }


}
