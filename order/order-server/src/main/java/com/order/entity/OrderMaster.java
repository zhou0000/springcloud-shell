package com.order.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/26 19:32
 */
@Data
public class OrderMaster {
    /**
     * 订单ID
     */
    private String orderId ;
    /**
     * 买家姓名
     */
    private String buyerName ;
    /**
     * 买家手机号
     */
    private String buyerPhone ;
    /**
     * 收货地址
     */
    private String buyerAddredd ;
    /**
     *  买家微信ID
     */
    private String buyerOpenid ;
    /**
     *  订单总金额
     */
    private BigDecimal orderAmount ;
    /**
     * 订单状态
     */
    private Integer orderStatus ;
    /**
     * 支付状态
     */
    private Integer payStatus ;
    /**
     * 订单创建时间
     */
    private Date createTime ;
    /**
     * 订单修改时间
     */
    private Date updateTime ;

    private List<OrderDetail> orderDetails;
}
