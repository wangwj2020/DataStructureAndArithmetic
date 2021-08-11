package com.wwj.dataStructure.stack;

import org.apache.commons.lang.StringUtils;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.dataStructure.stack
 * @ClassName: Expression
 * @Author: ASUS
 * @Description: 表达式求值
 * @Date: 2021/8/7 8:10
 * @Version: 1.0
 */
public class Expression {

    ArrayStack<Integer> numberStack;
    ArrayStack<OperatorEnum> operatorStack;

    public Expression() {
        numberStack = new ArrayStack<>(100);
        operatorStack = new ArrayStack<>(100);
    }

    public String compute(String expression) {
        String[] split = StringUtils.split(expression, " ");
        for (String str : split) {
            OperatorEnum operatorEnum = OperatorEnum.get(str);
            if (operatorEnum != null) {
                operatorProcess(operatorEnum);
            } else {
                numberProcess(str);
            }
        }
        Integer after = numberStack.pop();
        Integer before = numberStack.pop();
        return operatorStack.pop().compute(before,after)+"";
    }

    private void numberProcess(String str) {
        Integer number = Integer.valueOf(str);
        numberStack.push(number);
    }

    private void operatorProcess(OperatorEnum operatorEnum) {
        OperatorEnum operatorStackTop = operatorStack.getTop();
        if (operatorEnum.levelIsMoreThan(operatorStackTop)) {
            operatorStack.push(operatorEnum);
        } else {
            operatorStackTop = operatorStack.pop();
            Integer a = numberStack.pop();
            Integer b = numberStack.pop();
            int result = operatorStackTop.compute(a, b);
            numberStack.push(result);
            operatorProcess(operatorEnum);
        }
    }
}
