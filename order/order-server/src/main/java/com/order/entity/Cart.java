package com.order.entity;

import lombok.Data;

/**
 * @Author: zhou
 * @Date: 2020/1/26 19:34
 */
@Data
public class Cart {
    /**
     * 商品ID
     */

    private String productId;
    /**
     * 商品数量
     */
    private String productQuantity;
}
