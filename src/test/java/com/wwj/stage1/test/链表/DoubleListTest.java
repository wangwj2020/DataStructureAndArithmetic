package com.wwj.stage1.test.链表;

import com.wwj.stage1.dataStructure.line.list.DoubleList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.test.链表.单链表
 * @ClassName: DoubleLinkedTest
 * @Author: ASUS
 * @Description: test
 * @Date: 2021/8/6 17:06
 * @Version: 1.0
 */
public class DoubleListTest {

    @Test
    public void should_print_ok_if_add_ok() {
        DoubleList<String> DoubleList = new DoubleList<>();
        DoubleList.add("ok");
        assertEquals("ok,", DoubleList.print());
    }

    @Test
    public void should_return_ok_if_get_index_of_1() {
        DoubleList<String> DoubleList = new DoubleList<>();
        DoubleList.add("im");
        DoubleList.add("ok");
        String val = DoubleList.get(1);
        assertEquals("ok", val);
    }

    @Test
    public void should_print_im_if_remove_index_of_1() {
        DoubleList<String> DoubleList = new DoubleList<>();
        DoubleList.add("im");
        DoubleList.add("ok");
        DoubleList.remove(1);
        assertEquals("im,", DoubleList.print());
    }
}
