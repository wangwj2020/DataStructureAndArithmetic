package com.wwj.test.动态规划;

import com.wwj.arithmetic.dynamicProgramming.MinDist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * auth sherry
 * data created in 2021/10/17 7:39 下午
 */
class MinDistTest {

    @Test
    public void test() throws Exception {
        int[][] table = {{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
        MinDist minDist = new MinDist();
        minDist.minDisCal(table,4);
        minDist.print();
        int status = minDist.status[3][3];
        assertEquals(19,status);
    }
}
