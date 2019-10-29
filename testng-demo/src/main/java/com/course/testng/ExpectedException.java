package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void expectedException() {
        System.out.println("预期抛出一个运行时异常");
        throw new RuntimeException();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void expectedException2() {
        System.out.println("预期抛出一个运行时异常,未抛出则运行失败！");
    }
}
