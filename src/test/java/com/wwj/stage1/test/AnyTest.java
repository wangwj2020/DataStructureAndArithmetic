package com.wwj.stage1.test;

import org.junit.jupiter.api.Test;

import java.util.*;

public class AnyTest {

    @Test
    public void test() throws Exception {
        String regex ="^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])$";
        String data = "2012-00";
        System.out.println(data.matches(regex));
    }
}
