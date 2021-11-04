package com.wwj.stage1.test.回溯;

import com.wwj.stage1.backtracking.MinDIst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 回溯法求最短路径
 * auth sherry
 * data created in 2021/10/17 6:45 下午
 */
class MinDIstTest {

    @Test
    public void test() throws Exception {
        int[][] table = {{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
        MinDIst minDIst = new MinDIst();
        minDIst.minDistCal(table,1,0,0,4);
        assertEquals(19,minDIst.minDist);
    }

}
