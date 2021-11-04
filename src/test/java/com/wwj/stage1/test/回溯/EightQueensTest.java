package com.wwj.stage1.test.回溯;

import com.wwj.stage1.backtracking.EightQueens;
import org.junit.jupiter.api.Test;

/**
 * auth sherry
 * data created in 2021/10/13 4:28 下午
 */
class EightQueensTest {

    @Test
    public void test() throws Exception {
        EightQueens eightQueens = new EightQueens();
        eightQueens.cal8queens(0);
    }

}
