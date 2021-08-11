package com.wwj.test.链表;

import com.wwj.dataStructure.linked.DoubleLinked;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.链表.单链表
 * @ClassName: DoubleLinkedTest
 * @Author: ASUS
 * @Description: test
 * @Date: 2021/8/6 17:06
 * @Version: 1.0
 */
public class DoubleLinkedTest {

    @Test
    public void should_print_ok_if_add_ok() {
        DoubleLinked<String> DoubleLinked = new DoubleLinked<>();
        DoubleLinked.add("ok");
        assertEquals("ok,", DoubleLinked.print());
    }

    @Test
    public void should_return_ok_if_get_index_of_1() {
        DoubleLinked<String> DoubleLinked = new DoubleLinked<>();
        DoubleLinked.add("im");
        DoubleLinked.add("ok");
        String val = DoubleLinked.get(1);
        assertEquals("ok", val);
    }

    @Test
    public void should_print_im_if_remove_index_of_1() {
        DoubleLinked<String> DoubleLinked = new DoubleLinked<>();
        DoubleLinked.add("im");
        DoubleLinked.add("ok");
        DoubleLinked.remove(1);
        assertEquals("im,", DoubleLinked.print());
    }
}
