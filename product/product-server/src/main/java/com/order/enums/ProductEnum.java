package com.order.enums;

import lombok.Getter;

/**
 * @Author: zhou
 * @Date: 2020/1/26 14:54
 */
@Getter
public enum  ProductEnum {

    PRODUCT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_STACK_ERROR(2,"库存有误");

    private Integer code;

    private String msg;

    ProductEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }




}
