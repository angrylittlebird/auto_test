package com.course.testng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupTest {

    @BeforeGroups("server")
    public void beforeGroups(){
        System.out.println("this test is running before server groups");
    }

    @AfterGroups("server")
    public void afterGroups(){
        System.out.println("this test is running after server groups");
    }

    @Test(groups = "server")
    public void testServer1(){
        System.out.println("server test1");
    }

    @Test(groups = "server")
    public void testServer2(){
        System.out.println("server test2");
    }

    @Test(groups = "client")
    public void testClient1(){
        System.out.println("client test1");
    }

    @Test(groups = "client")
    public void testClient2(){
        System.out.println("client test2");
    }
}
