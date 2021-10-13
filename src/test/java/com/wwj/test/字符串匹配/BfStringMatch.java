package com.wwj.test.字符串匹配;

import com.wwj.arithmetic.stringMatch.BF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * auth sherry
 * data created in 2021/9/22 3:29 下午
 */
public class BfStringMatch {

    @Test
    public void should_return_lose_1_if_not_match() throws Exception {
        String str = "abcefghg";
        String childStr = "efgi";
        int startIndex = BF.startIndex(str, childStr);
        assertEquals(-1,startIndex);

    }

    @Test
    public void should_return_3_if_match_start_index_of_3() throws Exception {
        String str = "abcefghg";
        String childStr = "efg";
        int startIndex = BF.startIndex(str, childStr);
        assertEquals(3,startIndex);

    }
}
