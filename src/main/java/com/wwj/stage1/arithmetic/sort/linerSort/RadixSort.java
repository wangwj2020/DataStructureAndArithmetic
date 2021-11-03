package com.wwj.stage1.arithmetic.sort.linerSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序
 * 线性排序，时间复杂度O（N）
 * 原地排序：N
 * 使用前提：基数排序对要排序的数据是有要求的，需要可以分割出独立的“位”来比较，而且位之间有递进的关系，如果 a 数据的高位比 b 数据大，那剩下的低位就不用比较了。
 * 除此之外，每一位的数据范围不能太大，要可以用线性排序算法来排序，否则，基数排序的时间复杂度就无法做到 O(n) 了。
 */
public class RadixSort {

    public static void main(String[] args) {
        List<String> phoneList = Arrays.asList("13022392909", "13022392918", "13022392427", "13022393936", "13022372945"
                , "13022592954", "13028392963", "13082392972", "13622392981", "18022392990");
        radixSort(phoneList);

//        printList(phoneList);
    }


    public static void radixSort(List<String> phoneList) {
        for (int m = 10; m >= 0; m--) {
            List<String>[] numberArray = new List[10];
            printList(phoneList);
            System.out.println("+++++++++++++");
            for (String phone : phoneList) {
                int index = Integer.parseInt(phone.charAt(m) + "");
                addPhone(numberArray, phone, index);
            }
            phoneList = new ArrayList<>();
            for (List<String> phones : numberArray) {
                if (phones != null) {
                    phoneList.addAll(phones);
                }
            }
        }
    }

    private static void printList(List<String> phoneList) {
        for (String phone : phoneList) {
            System.out.println(phone);
        }
    }

    private static void addPhone(List<String>[] numberArray, String phone, int index) {
        List<String> list = numberArray[index];
        if (null == list || list.isEmpty()) {
            list = new ArrayList();
            numberArray[index] = list;
        }
        list.add(phone);
    }

}
