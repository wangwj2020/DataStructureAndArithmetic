package com.wwj.test.分治;

import com.wwj.arithmetic.reduce.DegreeOrder;
import com.wwj.arithmetic.reduce.DegreeOrder2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * auth sherry
 * data created in 2021/10/12 11:32 上午
 */
public class DegreeOrderTest {

    @Test
    public void should_return_equals_if_sort_right() throws Exception {
        DegreeOrder degreeOrder = new DegreeOrder();
        int[] arr = {6, 5, 8};
        degreeOrder.count(arr);
        assertEquals("5,6,8,",arr2Str(arr));
    }

    @Test
    public void should_return_4_if_count_degree_order_right() throws Exception {
        DegreeOrder2 degreeOrder = new DegreeOrder2();
//        DegreeOrder degreeOrder = new DegreeOrder();
        int[] arr = {2,4,3,1,5,6};
        int count = degreeOrder.count(arr);
        assertEquals(4,count);
    }

    private String arr2Str(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(",");
        }
        return sb.toString();
    }
}
