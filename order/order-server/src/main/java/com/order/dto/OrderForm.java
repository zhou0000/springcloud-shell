package com.order.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @Author: zhou
 * @Date: 2020/1/25 15:35
 * 该实体用来接收前端传过来的参数
 */
@Data
@ToString
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotBlank(message = "买家姓名不能为空")
    private String name;
    /**
     * 买家手机号
     */
    @NotBlank(message = "买家手机号不能为空")
    private String phone;
    /**
     * 买家地址
     */
    @NotBlank(message = "买家地址不能为空")
    private String address;
    /**
     * 买家微信ID
     */
    @NotBlank(message = "买家微信ID不能为空")
    private String openid;
    /**
     * 购物车
     */
    @NotBlank(message = "购物车不能为空")
    private String item;
}
