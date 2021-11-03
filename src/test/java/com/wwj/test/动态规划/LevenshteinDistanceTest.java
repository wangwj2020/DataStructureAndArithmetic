package com.wwj.test.动态规划;

import com.wwj.stage1.arithmetic.dynamicProgramming.LevenshteinDistance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * auth sherry
 * data created in 2021/10/18 8:35 下午
 */
class LevenshteinDistanceTest {

    @Test
    public void test() throws Exception {
        char[] c1 = "mitcmu".toCharArray();
        char[] c2 = "mtacnu".toCharArray();
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance(c1, c2);
        int distance = levenshteinDistance.calDistance(5, 5);
        assertEquals(3, distance);
    }
}
