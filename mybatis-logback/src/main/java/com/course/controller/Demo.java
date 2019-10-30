package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Log4j2
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RestController
@RequestMapping("v1")
public class Demo {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    public int getUserCount(){
        return sqlSessionTemplate.selectOne("getUserCount");
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
        return sqlSessionTemplate.insert("addUser", user);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){
        return sqlSessionTemplate.update("updateUser", user);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public int deleteUser(@RequestParam int id){
        return sqlSessionTemplate.update("deleteUser", id);
    }

}

