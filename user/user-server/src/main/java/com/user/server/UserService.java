package com.user.server;

import com.user.entity.UserInfo;

/**
 * @Author: zhou
 * @Date: 2020/1/28 15:35
 */
public interface UserService {
    UserInfo findUserByOpenId(String openId);
}
