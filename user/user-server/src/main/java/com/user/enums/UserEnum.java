package com.user.enums;

import lombok.Getter;

/**
 * @Author: zhou
 * @Date: 2020/1/28 15:18
 */
@Getter
public enum UserEnum {

    USER_NOT_EXIST(1,"用户不存在");
    private Integer code;
    private String value;

    UserEnum(Integer code,String value){
        this.code = code;
        this.value = value;
    }
}
