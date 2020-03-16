package com.order.converter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.dto.OrderForm;
import com.order.entity.Cart;
import com.order.entity.OrderDetail;
import com.order.entity.OrderMaster;
import com.order.exception.OrderParamException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhou
 * @Date: 2020/1/26 9:32
 */
@Slf4j
public class ConverterUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static OrderMaster orderFormToOrderDTO(OrderForm orderForm){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName(orderForm.getName());
        orderMaster.setBuyerAddredd(orderForm.getAddress());
        orderMaster.setBuyerOpenid(orderForm.getOpenid());
        orderMaster.setBuyerPhone(orderForm.getPhone());
        String item = orderForm.getItem();

        List<OrderDetail> orderDetails = new ArrayList<>();
        List<Cart> list = objectMapper.convertValue(item, List.class);
        try {
            orderDetails = parseArray(item,OrderDetail.class);
        } catch (IOException e) {
            log.error("【json转换】错误，string={}",e.getMessage());
            throw new OrderParamException("购物车参数有误");

        }
        orderMaster.setOrderDetails(orderDetails);
        return orderMaster;
    }

    public static <T> List<T> parseArray(String json, Class<T> clazz) throws IOException {
        List<T> result = new ArrayList<T>();
        List<Map<String, Object>> list = objectMapper.readValue(json, new TypeReference<List<T>>() {
        });
        for (Map<String, Object> one : list) {
            result.add(map2object(one, clazz));
        }
        return result;
    }
    private static <T> T map2object(Map<String, Object> map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }


}
