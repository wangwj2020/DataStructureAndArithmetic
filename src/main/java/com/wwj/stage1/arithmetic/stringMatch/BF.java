package com.wwj.stage1.arithmetic.stringMatch;

/**
 * 朴素匹配算法（brute force）
 * 时间复杂度：O(m*n),m主字符串长度，n模式字符串长度
 * auth sherry
 * data created in 2021/9/22 11:57 上午
 */
public class BF {

    public static int startIndex(String mainStr, String patternStr) {
        int m = mainStr.length();
        int n = patternStr.length();
        if (n > m) {
            return -1;
        }
        char targetChar = patternStr.charAt(0);
        for (int i = 0; i < m; i++) {
            char currentChar = mainStr.charAt(i);
            if (targetChar == currentChar) {
                boolean res = true;
                for (int i1 = 1; i1 < n; i1++) {
                    currentChar = mainStr.charAt(i + i1);
                    targetChar = patternStr.charAt(i1);
                    if (currentChar != targetChar) {
                        res = false;
                        break;
                    }
                }
                if (res) {
                    return i;
                }
            }
        }
        return -1;
    }
}
