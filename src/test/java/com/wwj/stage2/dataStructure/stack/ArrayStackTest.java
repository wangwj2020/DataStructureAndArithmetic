package com.wwj.stage2.dataStructure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * auth sherry
 * data created in 2021/11/9 12:04 上午
 */
class ArrayStackTest {

    @Test
    public void test_array_stack() throws Exception {
        ArrayStack arrayStack = new ArrayStack(5);
        for (int i = 0; i < 6; i++) {
            arrayStack.push(i + "");
        }

        String s = arrayStack.pop();
        assertEquals("4", s);
        s = arrayStack.pop();
        assertEquals("3", s);
        s = arrayStack.pop();
        assertEquals("2", s);
        s = arrayStack.pop();
        assertEquals("1", s);
        s = arrayStack.pop();
        assertEquals("0", s);
    }
}
