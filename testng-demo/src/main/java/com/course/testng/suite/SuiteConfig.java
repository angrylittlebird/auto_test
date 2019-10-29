package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("测试套件前执行的代码");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("测试套件后执行的代码");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("测试用例执行前的执行的代码");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("测试用例执行后的执行的代码");
    }
}
