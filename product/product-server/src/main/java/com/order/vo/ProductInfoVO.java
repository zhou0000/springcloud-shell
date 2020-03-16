package com.order.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: zhou
 * @Date: 2020/1/25 10:47
 */
@Data
public class ProductInfoVO {

    /**
     * 商品ID
     */
    @JsonProperty("id")
    private String productId;

    /**
     * 商品名称
     */
    @JsonProperty("name")
    private String productName;

    /**
     * 商品价格
     */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /**
     * 商品说明
     */
    @JsonProperty("description")
    private String productDescription;

    /**
     * 商品图标
     */
    @JsonProperty("icon")
    private String ProductIcon;
}
