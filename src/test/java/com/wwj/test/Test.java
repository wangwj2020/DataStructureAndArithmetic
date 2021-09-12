package com.wwj.test;

import lombok.Builder;
import lombok.Data;

import java.util.Random;

/**
 * @ProjectName: DataStructureAndArithmeticn
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

    public static void main(String[] args) {
        System.out.println(Math.random());
    }
}
