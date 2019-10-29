package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    //案例1
    @Test(dataProvider = "data1")
    public void testParameter(String name, int age) {
        System.out.println("name:" + name + ";age:" + age);
    }

    @DataProvider(name = "data1")
    public Object[][] provideData(){
        Object[][] objects = {
                {"张三", 12},
                {"李四", 13},
                {"王五", 14},
        };
        return objects;
    }

    //案例2

    @Test(dataProvider = "data2")
    public void testParameter2(String name, int age){
        System.out.println("这是测试方法testParameter2");
        System.out.println("name:" + name + ";age:" + age);
    }

    @Test(dataProvider = "data2")
    public void testParameter3(String name, int age){
        System.out.println("这是测试方法testParameter3");
        System.out.println("name:" + name + ";age:" + age);
    }

    @DataProvider(name = "data2")
    public Object[][] provideData2(Method method){
        Object[][] data = null;
        if(method.getName().equals("testParameter2")) {
            data = new Object[][]{
                    {"张三", 12},
                    {"李四", 13},
                    {"王五", 14},
            };
        }else if(method.getName().equals("testParameter3")){
            data = new Object[][]{
                    {"小明", 15},
                    {"小李", 16},
                    {"小订", 17},
            };
        }
        return data;
    }
}
