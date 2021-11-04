package com.wwj.stage2.test;

import com.wwj.stage2.dataStructure.linked.LruLinked;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * auth sherry
 * data created in 2021/11/3 11:09 下午
 */
class LruLinkedTest {

    @Test
    public void test_add() throws Exception {
        LruLinked<String> lruLinked = new LruLinked<>(3);
        lruLinked.add("1");
        lruLinked.add("2");
        lruLinked.add("3");
        lruLinked.add("1");
        String print = lruLinked.print();
        assertEquals("1,3,2,", print);
    }

    @Test
    public void test_remove() throws Exception {
        LruLinked<String> lruLinked = new LruLinked<>(3);
        lruLinked.add("1");
        lruLinked.add("2");
        lruLinked.add("3");
        System.out.println(lruLinked.print());
        lruLinked.remove("2");
        lruLinked.add("1");
        String print = lruLinked.print();
        assertEquals("1,3,1,", print);
    }
}
