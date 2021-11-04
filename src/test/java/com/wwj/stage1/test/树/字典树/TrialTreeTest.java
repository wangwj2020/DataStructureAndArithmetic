package com.wwj.stage1.test.树.字典树;

import com.wwj.stage1.dataStructure.tree.TrialTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * auth sherry
 * data created in 2021/10/11 7:19 下午
 */
public class TrialTreeTest {

    @Test
    public void should_return_true_if_find_success() throws Exception {
        TrialTree trialTree = new TrialTree('/');
        trialTree.insert("hello");
        trialTree.insert("he");
        trialTree.insert("her");
        trialTree.insert("hero");

        boolean res = trialTree.find("her");
        assertTrue(res);
        res = trialTree.find("hero");
        assertTrue(res);
        res = trialTree.find("hel");
        assertFalse(res);

    }
}
