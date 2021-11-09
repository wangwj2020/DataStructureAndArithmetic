package com.wwj.stage2.test;

import com.wwj.stage2.dataStructure.linked.JosephCycle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * auth sherry
 * data created in 2021/11/4 7:03 下午
 */
class JosephCycleTest {

    @Test
    public void test() throws Exception {
        JosephCycle<Integer> josephCycle = new JosephCycle<>(41);
        for (int i = 0; i < 41; i++) {
            josephCycle.add(i);
        }
        String remain = josephCycle.kill(3);
        System.out.println(remain);
        assertEquals("15,30,", remain);
    }
}
