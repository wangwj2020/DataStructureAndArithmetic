package com.wwj.test.链表;

import com.wwj.dataStructure.line.list.DoubleCycleList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.链表.单链表
 * @ClassName: DoubleCycleLinkedTest
 * @Author: ASUS
 * @Description: 循环双链表
 * @Date: 2021/8/6 17:06
 * @Version: 1.0
 */
public class DoubleCycleListTest {

    @Test
    public void should_print_ok_if_add_ok() {
        DoubleCycleList<String> DoubleCycleList = new DoubleCycleList<>();
        DoubleCycleList.add("ok");
        assertEquals("ok,", DoubleCycleList.print());
    }

    @Test
    public void should_return_ok_if_get_index_of_1() {
        DoubleCycleList<String> DoubleCycleList = new DoubleCycleList<>();
        DoubleCycleList.add("im");
        DoubleCycleList.add("ok");
        String val = DoubleCycleList.get(1);
        assertEquals("ok", val);
    }

    @Test
    public void should_print_im_if_remove_index_of_1() {
        DoubleCycleList<String> DoubleCycleList = new DoubleCycleList<>();
        DoubleCycleList.add("im");
        DoubleCycleList.add("ok");
        DoubleCycleList.remove(1);
        assertEquals("im,", DoubleCycleList.print());
    }
}
