package com.course.testng.multithread;

import org.testng.annotations.Test;

public class ThreadOnAnnotationTest {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("current thread id: %s",Thread.currentThread().getId());
    }
}
