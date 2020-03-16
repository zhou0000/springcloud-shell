package com.user.server.impl;

import com.user.entity.UserInfo;
import com.user.mapper.UserMapper;
import com.user.server.UserService;
import org.bouncycastle.crypto.tls.UserMappingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhou
 * @Date: 2020/1/28 15:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserInfo findUserByOpenId(String openId) {
        return userMapper.findUserByOpenId(openId);
    }
}
