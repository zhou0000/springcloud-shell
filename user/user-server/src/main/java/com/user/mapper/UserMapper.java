package com.user.mapper;

import com.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zhou
 * @Date: 2020/1/28 15:37
 */
@Mapper
public interface UserMapper {
    UserInfo findUserByOpenId(@Param("openId") String openId);
}
