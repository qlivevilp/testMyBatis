package cn.org.cerambycidae.testmybaits.controller;

import cn.org.cerambycidae.testmybaits.mapper.ShareMapper;
import cn.org.cerambycidae.testmybaits.mapper.UserMapper;
import cn.org.cerambycidae.testmybaits.pojo.User;
import cn.org.cerambycidae.testmybaits.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class HelloWorldController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ShareMapper shareMapper;

    @ResponseBody
    @RequestMapping("/HelloWorld")
    public String HelloWorld() {
        // 查询一个用户
        // 1. 设置查询结果集
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUIdEqualTo(1);
        criteria.andUNameEqualTo("Tang");
        // 2. 执行查询结果
        List<User> users = userMapper.selectByExample(userExample);
        User userTang = users.get(0);
        // 插入数据
        User userInstert = new User();
        userInstert.setWxId("112233");
        userInstert.setuName("hello");
        userInstert.setuSign("hello world");
        int line = userMapper.insertSelective(userInstert);
        return userTang.getWxId();
    }
}
