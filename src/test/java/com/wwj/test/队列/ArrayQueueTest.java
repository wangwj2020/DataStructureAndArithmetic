package com.wwj.test.队列;

import com.wwj.stage1.dataStructure.line.queue.ArrayQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.队列
 * @ClassName: ArrayQueue
 * @Author: ASUS
 * @Description: 顺序队列
 * @Date: 2021/8/8 7:56
 * @Version: 1.0
 */
public class ArrayQueueTest {

    @Test
    public void should_return_null_if_queue_is_empty(){
        ArrayQueue<String> arrayQueue = new ArrayQueue(10);
        String dequeue = arrayQueue.dequeue();
        assertNull(dequeue);
    }

    @Test
    public void should_return_false_if_enqueue_is_full(){
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(2);
        boolean result = arrayQueue.enqueue("1");
        assertTrue(result);
        boolean result2 = arrayQueue.enqueue("2");
        assertTrue(result2);
        boolean result3 = arrayQueue.enqueue("3");
        assertFalse(result3);
    }

    @Test
    public void should_return_ok_if_enqueue_ok(){
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(10);
        arrayQueue.enqueue("ok");
        arrayQueue.enqueue("im");
        String str = arrayQueue.dequeue();
        assertEquals("ok",str);
    }

    @Test
    public void should_return_ok_if_head_and_tail_equal_capacity(){
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.enqueue("hi");
        arrayQueue.enqueue("nice");
        arrayQueue.enqueue("meet");
        arrayQueue.enqueue("you");
        arrayQueue.enqueue(".");
        String str1 = arrayQueue.dequeue();
        assertEquals("hi",str1);
        String str2 = arrayQueue.dequeue();
        assertEquals("nice",str2);
        String str3 = arrayQueue.dequeue();
        assertEquals("meet",str3);
        String str4 = arrayQueue.dequeue();
        assertEquals("you",str4);
        String str5 = arrayQueue.dequeue();
        assertEquals(".",str5);

        boolean result = arrayQueue.enqueue("ok");
        assertTrue(result);

        String str6 = arrayQueue.dequeue();
        assertEquals("ok",str6);
    }
}
