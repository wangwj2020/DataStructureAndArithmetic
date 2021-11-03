package com.wwj.stage1.dataStructure.line.stack;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.stage1.dataStructure.line.stack
 * @ClassName: BracketsMatch
 * @Author: ASUS
 * @Description: 括号匹配
 * @Date: 2021/8/7 9:25
 * @Version: 1.0
 */
public class BracketsMatch {
    private ArrayStack<String> leftBracket;

    /**
     * 括号对应关系
     */
    private final Map<String, String> leftBracketMap;
    private final Map<String, String> rightBracketMap;

    public BracketsMatch(String[] brackets) {
        leftBracketMap = new HashMap<>();
        rightBracketMap = new HashMap<>();
        leftBracket = new ArrayStack<>(10);
        bracketMapInit(brackets);
    }

    public boolean bracketIsMatch(String str) {
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            String s = String.valueOf(aChar);
            if (leftBracketMap.containsKey(s)) {
                leftBracket.push(s);
            } else if (rightBracketMap.containsKey(s)) {
                String leftPopBracket = leftBracket.pop();
                String leftBracket = rightBracketMap.get(s);
                if (!StringUtils.equals(leftBracket, leftPopBracket)) {
                    return false;
                }
            } else {
                throw new IllegalArgumentException("非法括号");
            }
        }

        if (leftBracket.size != 0) {
            return false;
        }
        return true;
    }

    private void bracketMapInit(String[] brackets) {
        for (String bracket : brackets) {
            String[] split = StringUtils.splitByCharacterType(bracket);
            String leftBracket = split[0];
            String rightBracket = split[1];
            leftBracketMap.put(leftBracket, rightBracket);
            rightBracketMap.put(rightBracket, leftBracket);
        }
    }
}
