package com.user.server.impl;

import com.user.entity.UserInfo;
import com.user.server.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @Author: zhou
 * @Date: 2020/1/28 15:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void findUserByOpenId() {
        UserInfo userInfo = userService.findUserByOpenId("abc");
        System.out.println(userInfo);

    }
    @Test
    public void redisTest(){
        stringRedisTemplate.opsForValue().set("username","张三",60*1000, TimeUnit.SECONDS);



    }
}