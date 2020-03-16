package com.order.service.impl;

import com.order.client.ProductClient;
import com.order.entity.DecreaseStockInput;
import com.order.entity.OrderDetail;
import com.order.entity.OrderMaster;
import com.order.entity.ProductInfo;
import com.order.enums.ResultEnum;
import com.order.exception.ProductException;
import com.order.mapper.OrderDetailMapper;
import com.order.service.OrderService;
import com.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhou
 * @Date: 2020/1/26 11:26
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Override
    @Transactional
    public void create(OrderMaster orderMaster) {
        // 先生成一个订单ID
        String orderId = KeyUtil.genUniquerKey();
        // 根据商品ID，查询库存
        List<OrderDetail> orderDetails = orderMaster.getOrderDetails();
        List<String> pids = orderDetails.stream().map(orderDetail -> {
            return orderDetail.getProductId();
        }).collect(Collectors.toList());
        BigDecimal sumPrice = new BigDecimal(BigInteger.ZERO);
        List<ProductInfo> productInfos = productClient.listForOrder(pids);
        for (ProductInfo productInfo : productInfos) {
            for (OrderDetail orderDetail : orderDetails) {
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    // 每个商品的总价 数量*价格
                    sumPrice = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(sumPrice);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniquerKey());
                    // 插入订单详情
//                    orderDetailMapper.create(orderDetail);
                }
            }
        }
        //减库存
        List<DecreaseStockInput> decreaseStockInputs = orderDetails.stream().map(orderDetail -> {
            DecreaseStockInput decreaseStockInput = new DecreaseStockInput();
            decreaseStockInput.setProductId(orderDetail.getProductId());
            decreaseStockInput.setProductQuantity(orderDetail.getProductQuantity());
            return decreaseStockInput;
        }).collect(Collectors.toList());
        //productClient.decreaseStockInput(decreaseStockInputs);
        // 插入OrderMaster表
    }
}
