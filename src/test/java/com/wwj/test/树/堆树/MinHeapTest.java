package com.wwj.test.树.堆树;

import com.wwj.stage1.dataStructure.tree.MinHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * auth sherry
 * data created in 2021/10/31 10:47 下午
 */
class MinHeapTest {

    @Test
    public void should_return_true_if_add_is_ok() throws Exception {
        MinHeap minHeap = new MinHeap(6);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(5);
        minHeap.add(6);
        minHeap.add(4);
        String s =minHeap.print();
//        System.out.println(s);
        assertEquals("0,1,3,2,6,4,5,",s);
    }

    @Test
    public void should_return_true_if_remove_min_is_ok() throws Exception {
        MinHeap minHeap = new MinHeap(6);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(5);
        minHeap.add(6);
        minHeap.add(4);
        minHeap.removeMin();
        System.out.println(minHeap.print());
    }
}
