package com.wwj.stage2.algorithm.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * auth sherry
 * data created in 2021/11/30 9:43 上午
 */
public class BinarySearchTest {
    int[] arr = {1, 2, 3, 4, 66, 88, 88, 88, 9089, 12392};

    @Test
    public void test_search_first() throws Exception {
        BinarySearch binarySearch = new BinarySearch(arr);
        assertEquals(-1, binarySearch.searchFirstEquals(0));
        assertEquals(0, binarySearch.searchFirstEquals(1));
        assertEquals(5, binarySearch.searchFirstEquals(88));
        assertEquals(9, binarySearch.searchFirstEquals(12392));
    }

    @Test
    public void test_search_last() throws Exception {
        BinarySearch binarySearch = new BinarySearch(arr);
        assertEquals(-1, binarySearch.searchFirstEquals(0));
        assertEquals(0, binarySearch.searchLastEquals(1));
        assertEquals(7, binarySearch.searchLastEquals(88));
        assertEquals(9, binarySearch.searchLastEquals(12392));
    }
}
