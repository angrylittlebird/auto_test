package com.test.extent;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReportDemo {
    @Test
    public void fail(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void success(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void logDemo(){
        Reporter.log("日志：..............");
        throw new RuntimeException("运行时异常。。。。");
    }
}
