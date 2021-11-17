package com.wwj.stage2.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * auth sherry
 * data created in 2021/11/9 8:14 下午
 */
class ArraySortTest {

    @Test
    public void test_bubble_sort() throws Exception {
        int[] arr = {3, 2, 9, 2, 5, 4, 0};
        int[] ints = ArraySort.bubbleSort(arr, arr.length);
        System.out.println(arr2Str(ints));
        assertEquals("0,2,2,3,4,5,9,", arr2Str(ints));
    }

    @Test
    public void test_insertion_sort() throws Exception {
        int[] arr = {3, 2, 9, 2, 5, 4, 0};
        int[] ints = ArraySort.insertionSort(arr, arr.length);
        System.out.println(arr2Str(ints));
        assertEquals("0,2,2,3,4,5,9,", arr2Str(ints));
    }

    @Test
    public void test_selection_sort() throws Exception {
        int[] arr = {3, 2, 9, 2, 5, 4, 0};
        int[] ints = ArraySort.selectionSort(arr, arr.length);
        System.out.println(arr2Str(ints));
        assertEquals("0,2,2,3,4,5,9,", arr2Str(ints));
    }

    @Test
    public void test_merger_sort() throws Exception {
        int[] arr = {3, 2, 9, 2, 5, 4, 0};
        int[] ints = ArraySort.merger_sort(arr, arr.length);
        System.out.println(arr2Str(ints));
        assertEquals("0,2,2,3,4,5,9,", arr2Str(ints));
    }

    @Test
    public void test_quick_sort() throws Exception {
        int[] arr = {3, 2, 9, 2, 5, 4, 0};
        int[] ints = ArraySort.quick_sort(arr, arr.length);
        System.out.println(arr2Str(ints));
        assertEquals("0,2,2,3,4,5,9,", arr2Str(ints));
    }


    private String arr2Str(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int s = arr[i];
            sb.append(s).append(",");
        }
        return sb.toString();
    }
}
