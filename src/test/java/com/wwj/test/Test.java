package com.wwj.test;

import lombok.Builder;
import lombok.Data;

/**
 * @ProjectName: DataStructureAndArithmetic
 * @Package: com.wwj.test
 * @ClassName: Test
 * @Author: ASUS
 * @Description:
 * @Date: 2021/8/9 15:56
 * @Version: 1.0
 */
@Data
@Builder(builderMethodName ="hiddenBuilder",buildMethodName = "myBuild")
public class Test {

    private String name;

    private String like;

    public static TestBuilder builder() {

        return hiddenBuilder();
    }

    public Test init() {
        this.like =get();
        return this;
    }

    public String sayLike() {
        return name+"  "+like;
    }

    String get() {
        return "apple";
    }
}
