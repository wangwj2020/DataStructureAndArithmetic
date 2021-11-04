package com.wwj.stage1.test;

import org.junit.jupiter.api.Test;

import java.util.*;

public class AnyTest {

    @Test
    public void test() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println("while i is ->" + iterator.next());
            for (int i = 3; i > 0; i--) {
                if (i == 2) {
                    return;
                }
            }

        }
    }
}
