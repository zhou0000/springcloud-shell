package com.order.entity;

import lombok.Data;

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