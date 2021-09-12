package com.wwj.test.跳表;

import com.wwj.dataStructure.skiplist.SkipList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SkipListTest {

    @Test
    public void should_return_null_if_skip_list_has_no_element() {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(22);
        skipList.insert(11);
        skipList.insert(100);
        skipList.insert(3);
        SkipList.Node node = skipList.find(12);
        assertNull(node);
    }

    @Test
    public void should_return_equals_if_skip_list_has_element() {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(22);
        skipList.insert(11);
        skipList.insert(100);
        skipList.insert(3);

        SkipList.Node node = skipList.find(1);
        assertEquals(1,node.getData());

        node = skipList.find(3);
        assertEquals(3,node.getData());

        node = skipList.find(100);
        assertEquals(100,node.getData());

        skipList.printAll_beautiful();
    }

    @Test
    public void should_return_null_if_skip_list_find_one_that_already_delete() {
        SkipList skipList = new SkipList();
        skipList.insert(23);
        assertEquals(23,skipList.find(23).getData());

        skipList.delete(23);
        SkipList.Node node = skipList.find(23);
        assertNull(node);
    }
}
