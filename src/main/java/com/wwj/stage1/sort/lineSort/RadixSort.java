package com.wwj.stage1.sort.lineSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.arithmetic.sort.lineSort
 * @ClassName: RadixSort
 * @Author: ASUS
 * @Description: 基数排序
 * @Date: 2021/8/12 17:17
 * @Version: 1.0
 */
public interface RadixSort {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("13022828902", "13422328922", "13022828902", "13022828902", "13022828422", "13022828323",
                "13022823492", "13036828920", "13022826903", "16522828902", "1376827772");
        list = radixSort(list);
        for (String phone : list) {
            System.out.println("phone is " + phone);
        }

    }

    static List<String> radixSort(List<String> phoneList) {
        List<String>[] bucket = new ArrayList[11];

        for (int index = bucket.length - 1; index >= 0; index--) {
            for (String phone : phoneList) {
                System.out.println(phone.charAt(index));
                addPhone(bucket, Integer.valueOf(phone.charAt(index)+""), phone);
            }
            phoneList = Arrays.stream(bucket).flatMap(Collection::stream).collect(Collectors.toList());
        }
        return phoneList;
    }

    static void addPhone(List<String>[] phoneList, int index, String phone) {
        List<String> thisList = phoneList[index];
        if (thisList == null) {
            thisList = new ArrayList<>();
            phoneList[index] = thisList;
        }
        thisList.add(phone);
    }
}
