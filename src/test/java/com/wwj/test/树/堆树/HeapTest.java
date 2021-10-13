package com.wwj.test.树.堆树;

import com.wwj.dataStructure.tree.Heap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * auth sherry
 * data created in 2021/9/17 3:04 下午
 */
public class HeapTest {

    @Test
    public void should_return_true_is_sort_is_ok() throws Exception {
        Heap heap = new Heap(16);
        heap.insert(1);
        heap.insert(17);
        heap.insert(23);
        heap.insert(18);
        heap.insert(14);
        heap.insert(9);
        heap.insert(13);
        heap.insert(12);
        heap.insert(3);
        heap.insert(7);
        heap.insert(2);
        heap.sort();
        assertEquals("1,2,3,7,9,12,13,14,17,18,23,",heap.toString());
    }
}
