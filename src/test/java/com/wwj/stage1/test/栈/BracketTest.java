package com.wwj.stage1.test.栈;

import com.wwj.stage1.dataStructure.line.stack.BracketsMatch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.test.栈
 * @ClassName: ExpressionTest
 * @Author: ASUS
 * @Description: 括号匹配测试
 * @Date: 2021/8/7 8:10
 * @Version: 1.0
 */
public class BracketTest {

    @Test
    public void should_return_true_if_bracket_is_match() {
        String[] bracketArray = {"[]", "()", "{}"};
        BracketsMatch bracketsMatch = new BracketsMatch(bracketArray);
        boolean result = bracketsMatch.bracketIsMatch("{[()]}");
        assertTrue(result);
    }

    @Test
    public void should_return_false_if_bracket_is_not_match() {
        String[] bracketArray = {"[]", "()", "{}"};
        BracketsMatch bracketsMatch = new BracketsMatch(bracketArray);
        boolean result = bracketsMatch.bracketIsMatch("{[())]}");
        assertFalse(result);
    }

    @Test
    public void should_throw_exception_if_has_illegal_bracket() {
        try {
            String[] bracketArray = {"[]", "()", "{}"};
            BracketsMatch bracketsMatch = new BracketsMatch(bracketArray);
            bracketsMatch.bracketIsMatch("s{[())]}");
        } catch (Exception e) {
            assertEquals("非法括号", e.getMessage());
        }
    }

}
