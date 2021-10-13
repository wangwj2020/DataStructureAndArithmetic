package com.wwj.test.队列;

import com.wwj.dataStructure.line.queue.CycleArrayQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.队列
 * @ClassName: CycleArrayQueue
 * @Author: ASUS
 * @Description: 顺序队列
 * @Date: 2021/8/8 7:56
 * @Version: 1.0
 */
public class CycleArrayQueueTest {

    @Test
    public void should_return_null_if_queue_is_empty() {
        CycleArrayQueue<String> CycleArrayQueue = new CycleArrayQueue(10);
        String dequeue = CycleArrayQueue.dequeue();
        assertNull(dequeue);
    }

    @Test
    public void should_return_false_if_enqueue_is_full() {
        CycleArrayQueue<String> CycleArrayQueue = new CycleArrayQueue<>(2);
        boolean result = CycleArrayQueue.enqueue("1");
        assertTrue(result);
        boolean result2 = CycleArrayQueue.enqueue("2");
        assertTrue(result2);
        boolean result3 = CycleArrayQueue.enqueue("3");
        assertFalse(result3);
    }

    @Test
    public void should_return_ok_if_enqueue_ok() {
        CycleArrayQueue<String> CycleArrayQueue = new CycleArrayQueue<>(10);
        CycleArrayQueue.enqueue("ok");
        CycleArrayQueue.enqueue("im");
        String str = CycleArrayQueue.dequeue();
        assertEquals("ok", str);
    }

    @Test
    public void should_return_right_if_is_new_cycle() {
        CycleArrayQueue<String> CycleArrayQueue = new CycleArrayQueue<>(5);
        CycleArrayQueue.enqueue("hi");
        CycleArrayQueue.enqueue("nice");
        CycleArrayQueue.enqueue("meet");
        CycleArrayQueue.enqueue("you");
        CycleArrayQueue.enqueue(".");
        String str = CycleArrayQueue.dequeue();
        assertEquals("hi", str);
        str = CycleArrayQueue.dequeue();
        assertEquals("nice", str);

        boolean result = CycleArrayQueue.enqueue("ok");
        assertTrue(result);
        result = CycleArrayQueue.enqueue("im");
        assertTrue(result);
        result = CycleArrayQueue.enqueue("fine");
        assertFalse(result);

        str = CycleArrayQueue.dequeue();
        assertEquals("meet", str);
        str = CycleArrayQueue.dequeue();
        assertEquals("you", str);
        str = CycleArrayQueue.dequeue();
        assertEquals(".", str);
        str = CycleArrayQueue.dequeue();
        assertEquals("ok", str);
        str = CycleArrayQueue.dequeue();
        assertEquals("im", str);
        str = CycleArrayQueue.dequeue();
        assertNull(str);


    }
}
