package com.wwj.test.回溯;

import com.wwj.arithmetic.backtracking.LevenshteinDistance;
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
        levenshteinDistance.calDistance(0, 0, 0);
        assertEquals(3, levenshteinDistance.minEditorCount);
    }
}
