package com.wwj.stage2.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * auth sherry
 * data created in 2021/11/22 9:58 下午
 */
class LineSortTest {

    @Test
    public void test_radix_sort() throws Exception {
        List<String> phoneList = Arrays.asList("13022392909", "13022392918", "13022392427", "13022393936", "13022372945"
            , "13022592954", "13028392963", "13082392972", "13622392981", "18022392990");
        List<String> sort = LineSort.radixSort(phoneList);
        System.out.println(printList(sort));
        assertEquals("13022372945,13022392427,13022392909,13022392918,13022393936,13022592954,13028392963,13082392972,13622392981,18022392990,",
            printList(sort));
    }

    private static String printList(List<String> phoneList) {
        StringBuilder sb = new StringBuilder();
        for (String phone : phoneList) {
            sb.append(phone).append(",");
        }
        return sb.toString();
    }
}
