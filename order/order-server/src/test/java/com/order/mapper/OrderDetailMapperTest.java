package com.order.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.client.ProductClient;
import com.order.entity.DecreaseStockInput;
import com.order.entity.OrderDetail;
import com.order.utils.KeyUtil;
import org.apache.commons.math.stat.descriptive.summary.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Author: zhou
 * @Date: 2020/1/27 10:51
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailMapperTest {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

//    @MockBean
    @Autowired
    private ProductClient productClient;
    @Test
    public void create(){
        String orderId = KeyUtil.genUniquerKey();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setDetailId(KeyUtil.genUniquerKey());
        orderDetail.setProductId("1575377470578");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductIcon("img path");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);
        orderDetail.setCreateTime(new Date());
        orderDetailMapper.create(orderDetail);
    }


    @Test
    public void client() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<DecreaseStockInput> inputs = new ArrayList<>();
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput();
        decreaseStockInput.setProductId("1575377470578");
        decreaseStockInput.setProductQuantity(2);
        inputs.add(decreaseStockInput);
        String str = objectMapper.writeValueAsString(inputs);
        System.out.println("传入的值："+str);
        productClient.decreaseStockInput(str);
    }

}