package com.wwj.test.队列;

import com.wwj.dataStructure.queue.LinkedQueue;
import com.wwj.dataStructure.queue.LinkedQueue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.队列
 * @ClassName: LinkedQueue
 * @Author: ASUS
 * @Description: 链表队列
 * @Date: 2021/8/8 7:56
 * @Version: 1.0
 */
public class LinkedQueueTest {

    @Test
    public void should_return_null_if_queue_is_empty(){
        LinkedQueue<String> linkedQueue = new LinkedQueue();
        String dequeue = linkedQueue.dequeue();
        assertNull(dequeue);
    }

    @Test
    public void should_return_ok_if_enqueue_ok(){
        LinkedQueue<String> LinkedQueue = new LinkedQueue<>();
        LinkedQueue.enqueue("ok");
        LinkedQueue.enqueue("im");
        String str = LinkedQueue.dequeue();
        assertEquals("ok",str);
    }

    @Test
    public void should_return_ok_if_head_and_tail_equal_capacity(){
        LinkedQueue<String> LinkedQueue = new LinkedQueue<>();
        LinkedQueue.enqueue("hi");
        LinkedQueue.enqueue("nice");
        LinkedQueue.enqueue("meet");
        LinkedQueue.enqueue("you");
        LinkedQueue.enqueue(".");
        String str1 = LinkedQueue.dequeue();
        assertEquals("hi",str1);
        String str2 = LinkedQueue.dequeue();
        assertEquals("nice",str2);
        String str3 = LinkedQueue.dequeue();
        assertEquals("meet",str3);
        String str4 = LinkedQueue.dequeue();
        assertEquals("you",str4);
        String str5 = LinkedQueue.dequeue();
        assertEquals(".",str5);

        LinkedQueue.enqueue("ok");

        String str6 = LinkedQueue.dequeue();
        assertEquals("ok",str6);
    }
}
