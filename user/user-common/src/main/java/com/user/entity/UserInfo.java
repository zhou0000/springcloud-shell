package com.user.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: zhou
 * @Date: 2020/1/28 14:58
 */
@Data
@ToString
public class UserInfo {
    private String id;
    private String username ;
    private String password;
    private String open_id;
    private Integer role ;
    private Data create_time;
    private Data update_time;
}
