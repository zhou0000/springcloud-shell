package com.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.client.ProductClient;
import com.order.converter.ConverterUtil;
import com.order.dto.OrderForm;
import com.order.entity.OrderMaster;
import com.order.exception.OrderParamException;
import com.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @Author: zhou
 * @Date: 2020/1/25 15:42
 */
@Controller
@RequestMapping("order")
@Slf4j
public class OrderController {


    @Autowired
    private OrderService orderService;
    @PostMapping("create")
    public void create(@Valid OrderForm orderForm, BindingResult result){
        if(result.hasErrors()){
            throw new OrderParamException(result.getFieldError().getDefaultMessage());
        }
        OrderMaster orderMaster = ConverterUtil.orderFormToOrderDTO(orderForm);
        if(CollectionUtils.isEmpty(orderMaster.getOrderDetails())){
            log.error("【创建订单，购物车信息为空】");
            throw new OrderParamException("购物车信息为空");
        }
        orderService.create(orderMaster);
    }

    @Autowired
    private ProductClient productClient;

    @GetMapping("desc")
    public void desc(){
        String str = "并欺凌";
        productClient.decreaseStockInput(str);
    }
}
