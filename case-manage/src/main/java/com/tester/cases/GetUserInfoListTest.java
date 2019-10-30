package com.tester.cases;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.tester.config.TestConfig;
import com.tester.model.GetUserListCase;
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
import java.util.List;

public class GetUserInfoListTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的用户信息")
    public void getUserListInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();

        GetUserListCase userListCase = sqlSession.selectOne("getUserListCase", 1);
        JSONArray actual = getResult(userListCase);

        List<User> expected = sqlSession.selectList(userListCase.getExpected(), userListCase);

        Assert.assertEquals(actual.length(), expected.size());

        for (int i = 0; i < actual.length(); i++) {
            JSONObject expectJson = new JSONObject(expected.get(i));
            JSONObject actualJson = (JSONObject) actual.get(i);
            Assert.assertEquals(expectJson.toString(), actualJson.toString());
        }
    }

    private JSONArray getResult(GetUserListCase userListCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        post.setEntity(new StringEntity(new JSONObject(userListCase).toString(), "utf-8"));
        post.setHeader("content-type", "application/json");

        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");

        return new JSONArray(result);
    }
}
