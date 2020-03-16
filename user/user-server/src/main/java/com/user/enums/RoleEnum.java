package com.user.enums;

import lombok.Getter;

/**
 * @Author: zhou
 * @Date: 2020/1/28 15:10
 */
@Getter
public enum RoleEnum {
    USER_ROLE_BUY(1,"买家"),
    USER_ROLE_SELLER(2,"卖家"),
    USER_ROLE_ERROR(3,"角色权限有误");

    private Integer code;
    private String value;
    RoleEnum(Integer code,String value){
        this.code = code;
        this.value = value;
    }
}
