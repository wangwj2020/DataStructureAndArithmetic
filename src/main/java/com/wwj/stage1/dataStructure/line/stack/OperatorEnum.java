package com.wwj.stage1.dataStructure.line.stack;

import org.apache.commons.lang.StringUtils;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.dataStructure.line.stack
 * @ClassName: OperatorEnum2
 * @Author: ASUS
 * @Description: 运算符表达式
 * @Date: 2021/8/7 8:22
 * @Version: 1.0
 */
public enum OperatorEnum {
    ADD("+", 1),

    SUBTRACT("-", 1),

    MULTIPLY("*", 2),

    DIVIDE("/", 2);

    private String operator;
    private int level;

    OperatorEnum(String operator, int level) {
        this.operator = operator;
        this.level = level;
    }

    public static OperatorEnum get(String operator) {
        for (OperatorEnum value : OperatorEnum.values()) {
            if (StringUtils.equals(value.operator, operator)) {
                return value;
            }
        }
        return null;
    }

    public boolean levelIsMoreThan(OperatorEnum operatorEnum) {
        return operatorEnum == null || this.level > operatorEnum.level;
    }

    public int compute(int a, int b) {
        if (StringUtils.equals("+", operator)) {
            return Math.addExact(a, b);
        } else if (StringUtils.equals("-", operator)) {
            return Math.subtractExact(a, b);
        } else if (StringUtils.equals("*", operator)) {
            return Math.multiplyExact(a, b);
        } else {
            return Math.floorDiv(a, b);
        }

    }
}
