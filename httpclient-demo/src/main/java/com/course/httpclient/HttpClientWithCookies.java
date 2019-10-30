package com.course.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class HttpClientWithCookies {
    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        DefaultHttpClient client = new DefaultHttpClient();
        String testUrl = this.url + bundle.getString("test.get.cookie.uri");
        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);
        EntityUtils.toString(response.getEntity(), "utf-8");


        this.cookieStore = client.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        System.out.println(cookies);

    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        DefaultHttpClient client = new DefaultHttpClient();
        String testUrl = this.url + bundle.getString("test.get.with.cookie");
        HttpGet httpGet = new HttpGet(testUrl);

        client.setCookieStore(this.cookieStore);
        HttpResponse response = client.execute(httpGet);

        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode == 200){
            System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostWithCookies() throws IOException {
        DefaultHttpClient client = new DefaultHttpClient();
        String testUrl = this.url + bundle.getString("test.post.with.cookie");
        HttpPost httpPost = new HttpPost(testUrl);

        //设置头信息
        httpPost.setHeader("Content-Type","application/json");

        //设置参数（json格式）
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "zhangsan");
        jsonObject.put("age", 10);
        httpPost.setEntity(new StringEntity(jsonObject.toString()));

        //设置cookie
        client.setCookieStore(this.cookieStore);

        HttpResponse response = client.execute(httpPost);
        HttpEntity result = response.getEntity();
        String resultString = EntityUtils.toString(result);
        System.out.println(resultString);

        JSONObject resultJson = new JSONObject(resultString);
        String name = (String)resultJson.get("name");
        int status = (Integer) resultJson.get("status");
        Assert.assertEquals(name,"zhangsan");
        Assert.assertEquals(status,1);

    }
}
