package com.order.api;

import com.order.entity.DecreaseStockInput;
import com.order.entity.ProductInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/26 17:12
 */
@RequestMapping("product")
public interface ProductApi {

    /**
     * 获取商品列表，给订单调用
     * @param pIds
     * @return
     */
    @GetMapping("listForOrder")
    List<ProductInfo>listForOrder(List<String> pIds);

    /**
     * 减库存，订单服务调用
     * @param inputs
     */
    @GetMapping("decreaseStock")
    void decreaseStockInput(@RequestParam("inputs") String inputs);
}
