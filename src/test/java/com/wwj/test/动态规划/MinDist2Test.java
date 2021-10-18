package com.wwj.test.动态规划;

import com.wwj.arithmetic.dynamicProgramming.MinDist2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * auth sherry
 * data created in 2021/10/17 8:52 下午
 */
class MinDist2Test {

    @Test
    public void test() throws Exception {
        MinDist2 minDist2 = new MinDist2();
        int minDisValue = minDist2.minDisCal(3, 3);
        assertEquals(19,minDisValue);
    }
}
