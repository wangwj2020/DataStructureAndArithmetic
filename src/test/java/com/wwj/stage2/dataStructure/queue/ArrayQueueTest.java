package com.wwj.stage2.dataStructure.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * auth sherry
 * data created in 2021/11/9 10:07 上午
 */
class ArrayQueueTest {

    @Test
    public void test_enqueue() throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        for (int i = 0; i < 5; i++) {
            arrayQueue.enQueue("" + i);
        }

        boolean enQueue = arrayQueue.enQueue("6");
        assertFalse(enQueue);

    }

    @Test
    public void test_dequeue() throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        for (int i = 0; i < 5; i++) {
            arrayQueue.enQueue("" + i);
        }

        boolean enQueue = arrayQueue.enQueue("");
        assertFalse(enQueue);

        for (int i = 0; i < 5; i++) {
            String s = arrayQueue.deQueue();
            System.out.println(s);
            assertEquals(s, i + "");
        }

        enQueue = arrayQueue.enQueue("");
        assertTrue(enQueue);

    }
}
