package com.course.testng;

import org.testng.annotations.*;

//主要关注执行顺序和执行次数

public class BasicAnnotation {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("----beforeSuite测试套件----");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("----afterSuite测试套件----");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("----这是在整个测试类运行前执行的方法----");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("----这是在整个测试类运行后执行的方法----");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是在每个测试用例之前执行的代码");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是在每个测试用例之后执行的代码");
        System.out.println("-----------------------------");
    }

    @Test
    public void testCase1() {
        System.out.println("这是基本的测试用例1！");
    }

    @Test
    public void testCase2() {
        System.out.println("这是基本的测试用例2！");
    }
}
