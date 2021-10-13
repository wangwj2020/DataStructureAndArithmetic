package com.wwj.test.栈;

import com.wwj.dataStructure.line.stack.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test.栈
 * @ClassName: ExpressionTest
 * @Author: ASUS
 * @Description: 表达式求值测试
 * @Date: 2021/8/7 8:10
 * @Version: 1.0
 */
public class ExpressionTest {

    @Test
    public void should_return_2_if_1_add_1(){
        Expression expression = new Expression();
        String result = expression.compute("1 + 1");
        assertEquals("2",result);
    }

    @Test
    public void should_return_2_if_3_sub_1(){
        Expression expression = new Expression();
        String result = expression.compute("3 - 1");
        assertEquals("2",result);
    }

    @Test
    public void should_return_6_if_3_mul_2(){
        Expression expression = new Expression();
        String result = expression.compute("3 * 2");
        assertEquals("6",result);
    }

    @Test
    public void should_return_3_if_6_mul_2(){
        Expression expression = new Expression();
        String result = expression.compute("6 / 2");
        assertEquals("3",result);
    }

    @Test
    public void should_return_37_if_3add5mul8sub6(){
        Expression expression = new Expression();
        String result = expression.compute("3 + 5 * 8 - 6");
        assertEquals("37",result);
    }
}
