package com.wwj.stage2.test;

import com.wwj.stage2.dataStructure.linked.CycleLinked;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * auth sherry
 * data created in 2021/11/3 10:21 下午
 */
class CycleLinkedTest {

    @Test
    public void test_add_full() throws Exception {
        CycleLinked<String> cycleLinked = new CycleLinked<>(5);
        assertThrows(RuntimeException.class, () -> {
            for (int i = 0; i < 6; i++) {
                cycleLinked.add(i + "");
            }
        });
    }

    @Test
    public void test_add() throws Exception {
        CycleLinked<String> cycleLinked = new CycleLinked<>(5);
        cycleLinked.add("1");
        cycleLinked.add("2");
        cycleLinked.add("3");
        cycleLinked.add("4");
        cycleLinked.add("5");
        String print = cycleLinked.print();
        assertEquals("1,2,3,4,5,", print);
    }

    @Test
    public void test_remove() throws Exception {
        CycleLinked<String> cycleLinked = new CycleLinked<>(5);
        cycleLinked.add("1");
        cycleLinked.add("2");
        cycleLinked.add("3");
        cycleLinked.add("4");
        cycleLinked.add("5");

        cycleLinked.remove("2");
        cycleLinked.add("5");
        String print = cycleLinked.print();
        assertEquals("1,3,4,5,", print);
    }

}
