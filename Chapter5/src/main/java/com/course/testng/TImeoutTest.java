package com.course.testng;

import org.testng.annotations.Test;

public class TImeoutTest {
    @Test(timeOut = 3000)
    public void test1() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test(timeOut = 3000)
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
    }
}
