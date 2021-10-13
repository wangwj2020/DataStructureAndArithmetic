package com.wwj.test.链表;

import com.wwj.dataStructure.line.list.LruSingleList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.链表.单链表
 * @ClassName: DoubleLinkedTest
 * @Author: ASUS
 * @Description: lru单链表测试
 * @Date: 2021/8/6 17:06
 * @Version: 1.0
 */
public class LruSingleListTest {

    @Test
    public void should_return_0_if_first_find() {
        LruSingleList<String> lruSingleList = new LruSingleList<>(3);
        int index = lruSingleList.find("im");
        assertEquals(0, index);
        index = lruSingleList.find("ok");
        assertEquals(0, index);
        index = lruSingleList.find("fine");
        assertEquals(0, index);
    }

    @Test
    public void should_return_3_if_find_after_capacity_is_full() {
        LruSingleList<String> lruSingleList = new LruSingleList<>(3);
        lruSingleList.find("im");
        lruSingleList.find("ok");
        lruSingleList.find("fine");

        int index = lruSingleList.find("im");
        assertEquals(3, index);
        index = lruSingleList.find("ok");
        assertEquals(3, index);
        index = lruSingleList.find("fine");
        assertEquals(3, index);
    }


}
