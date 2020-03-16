package com.order.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 15:31
 */
@Data
@ToString
public class OrderDetail {
    /**
     * 订单详情ID
     */
    private String detailId ;
    /**
     * 订单ID
     */
    private String orderId ;
    /**
     * 商品ID
     */
    private String productId ;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private BigDecimal productPrice;
    /**
     * 商品总数量
     */
    private Integer productQuantity;
    /**
     * 商品小图标
     */
    private String productIcon ;
    /**
     * 订单详情创建时间
     */
    private Date createTime ;
    /**
     * 订单详情修改时间
     */
    private Date updateTime  ;

    private List<OrderDetail> orderDetails;
}
