package com.wwj.stage2.algorithm.sort;

import java.util.LinkedList;
import java.util.List;

/**
 * 线性排序
 * auth sherry
 * data created in 2021/11/22 6:57 下午
 */
public class LineSort {

    /**
     * 基数排序
     */
    public static List<String> radixSort(List<String> phoneList) {
        LinkedList[] phoneArray = new LinkedList[11];
        for (int i = 0; i <= 10; i++) {
            phoneArray[i] = new LinkedList<>();
        }

        for (int i = 10; i >= 0; i--) {
            for (String phone : phoneList) {
                int phoneNumber = phone.charAt(i) - "0".charAt(0);
                phoneArray[phoneNumber].add(phone);
            }
            phoneList = new LinkedList<>();
            for (int m = 0; m <= 10; m++) {
                phoneList.addAll(phoneArray[m]);
                phoneArray[m] = new LinkedList();
            }
        }
        return phoneList;
    }
}
