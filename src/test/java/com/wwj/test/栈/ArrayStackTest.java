package com.wwj.test.栈;

import com.wwj.dataStructure.stack.ArrayStack;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.栈
 * @ClassName: ArrayStackTest
 * @Author: ASUS
 * @Description: 顺序栈测试
 * @Date: 2021/8/7 7:14
 * @Version: 1.0
 */
public class ArrayStackTest {

    @Test
    public void should_return_index_0_if_first_push() {
        ArrayStack<String> arrayStack = new ArrayStack<>(3);
        int index = arrayStack.push("1");
        assertEquals(index, 0);
    }

    @Test
    public void should_return_index_1_if_seconder_push() {
        ArrayStack<String> arrayStack = new ArrayStack<>(3);
        arrayStack.push("1");
        int index = arrayStack.push("2");
        assertEquals(index, 1);
    }

    @Test
    public void should_return_3_if_last_push_is_3() {
        ArrayStack<String> arrayStack = new ArrayStack<>(3);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");

        String pop = arrayStack.pop();
        assertEquals("3", pop);
    }
}
