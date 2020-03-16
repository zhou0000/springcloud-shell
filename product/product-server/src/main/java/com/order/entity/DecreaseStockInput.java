package com.order.entity;

import lombok.Data;

/**
 * @Author: zhou
 * @Date: 2020/1/26 14:36
 * 调用product减库存的方法传入的参数
 */
@Data
public class DecreaseStockInput {

    /**
     * 商品ID
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;


}
