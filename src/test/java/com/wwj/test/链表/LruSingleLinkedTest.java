package com.wwj.test.链表;

import com.wwj.dataStructure.linked.LruSingleLinked;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.链表.单链表
 * @ClassName: DoubleLinkedTest
 * @Author: ASUS
 * @Description: lru单链表测试
 * @Date: 2021/8/6 17:06
 * @Version: 1.0
 */
public class LruSingleLinkedTest {

    @Test
    public void should_return_0_if_first_find() {
        LruSingleLinked<String> lruSingleLinked = new LruSingleLinked<>(3);
        int index = lruSingleLinked.find("im");
        assertEquals(0, index);
        index = lruSingleLinked.find("ok");
        assertEquals(0, index);
        index = lruSingleLinked.find("fine");
        assertEquals(0, index);
    }

    @Test
    public void should_return_3_if_find_after_capacity_is_full() {
        LruSingleLinked<String> lruSingleLinked = new LruSingleLinked<>(3);
        lruSingleLinked.find("im");
        lruSingleLinked.find("ok");
        lruSingleLinked.find("fine");

        int index = lruSingleLinked.find("im");
        assertEquals(3, index);
        index = lruSingleLinked.find("ok");
        assertEquals(3, index);
        index = lruSingleLinked.find("fine");
        assertEquals(3, index);
    }


}
