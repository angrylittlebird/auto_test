package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void test1() {
        System.out.println("这是被依赖的的测试用例test1");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() {
        System.out.println("执行该测试用例test2前会先执行它依赖的方法");
    }

    @Test
    public void test3() {
        System.out.println("这是被依赖的的测试用例test3");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test3"})
    public void test4() {
        System.out.println("如果该测试用例依赖的测试用例test3执行失败，该测试用例将不再执行");//Total tests run: 2, Passes: 0, Failures: 1, Skips: 1
    }
}
