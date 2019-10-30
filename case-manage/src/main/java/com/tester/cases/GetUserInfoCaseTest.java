package com.tester.cases;

import com.tester.config.TestConfig;
import com.tester.model.GetUserInfoCase;
import com.tester.model.User;
import com.tester.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfoCaseTest {
    @Test(description = "获取用户id为1的用户",dependsOnGroups = "loginTrue")
    public void getUserInfo() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase= session.selectOne("getUserInfoCase", 1);

        JSONArray acutal = getResult(getUserInfoCase);

        User expected = session.selectOne(getUserInfoCase.getExpected(), getUserInfoCase.getUserId());

        Assert.assertEquals(acutal.length(),1);
        Assert.assertEquals(acutal.get(0).toString(),new JSONObject(expected).toString());
    }

    private JSONArray getResult(GetUserInfoCase getUserInfoCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("id", getUserInfoCase.getUserId());
        post.setEntity(new StringEntity(param.toString(), "utf-8"));
        post.setHeader("content-type", "application/json");

        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        return new JSONArray(result);
    }
}
