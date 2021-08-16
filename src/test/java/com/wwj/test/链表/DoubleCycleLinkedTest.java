package com.wwj.test.链表;

import com.wwj.dataStructure.list.DoubleCycleLinked;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.链表.单链表
 * @ClassName: DoubleCycleLinkedTest
 * @Author: ASUS
 * @Description: 循环双链表
 * @Date: 2021/8/6 17:06
 * @Version: 1.0
 */
public class DoubleCycleLinkedTest {

    @Test
    public void should_print_ok_if_add_ok() {
        DoubleCycleLinked<String> DoubleCycleLinked = new DoubleCycleLinked<>();
        DoubleCycleLinked.add("ok");
        assertEquals("ok,", DoubleCycleLinked.print());
    }

    @Test
    public void should_return_ok_if_get_index_of_1() {
        DoubleCycleLinked<String> DoubleCycleLinked = new DoubleCycleLinked<>();
        DoubleCycleLinked.add("im");
        DoubleCycleLinked.add("ok");
        String val = DoubleCycleLinked.get(1);
        assertEquals("ok", val);
    }

    @Test
    public void should_print_im_if_remove_index_of_1() {
        DoubleCycleLinked<String> DoubleCycleLinked = new DoubleCycleLinked<>();
        DoubleCycleLinked.add("im");
        DoubleCycleLinked.add("ok");
        DoubleCycleLinked.remove(1);
        assertEquals("im,", DoubleCycleLinked.print());
    }
}
