package com.order.enums;

import lombok.Getter;

/**
 * @Author: zhou
 * @Date: 2020/1/26 11:12
 */
@Getter
public enum ResultEnum {

    PRODUCDT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_PARA_ERROR(2,"参数有误"),
    PRODUCT_STOCK_ERROR(3,"库存不足");

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
