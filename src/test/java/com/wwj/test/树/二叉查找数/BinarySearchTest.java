package com.wwj.test.树.二叉查找数;

import com.wwj.dataStructure.tree.BinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * auth sherry
 * data created in 2021/9/15 4:45 下午
 */
public class BinarySearchTest {

    @Test
    public void should_find_the_node_that_value_is_1_if_already_insert_this() throws Exception {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(1);

        BinarySearchTree.Node node = binarySearchTree.find(1);
        assertEquals(1, node.getValue());
    }

    @Test
    public void should_find_null_if_already_remove() throws Exception {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(23);
        binarySearchTree.insert(2);
        binarySearchTree.insert(34);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        binarySearchTree.insert(99);

        BinarySearchTree.Node node = binarySearchTree.find(99);
        assertEquals(99, node.getValue());

        binarySearchTree.remove(99);
        node = binarySearchTree.find(99);
        assertNull(node);
    }

    @Test
    public void should_return_equals_if_sort_is_right() throws Exception {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(23);
        binarySearchTree.insert(2);
        binarySearchTree.insert(34);
        binarySearchTree.insert(3);
        binarySearchTree.insert(5);
        binarySearchTree.insert(99);

        String middleSort = binarySearchTree.middleSort();
        assertEquals("2,3,5,23,34,99,", middleSort);

    }

    @Test
    public void test() throws Exception {

        for (int i = 3; i > 0; i--) {
            System.out.println("i = " + i);
        }

        for (int i = 3; i > 0; --i) {
            System.out.println("iz = " + i);
        }

    }

}
