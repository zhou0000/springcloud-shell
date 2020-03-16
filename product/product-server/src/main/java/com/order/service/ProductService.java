package com.order.service;


import com.order.entity.DecreaseStockInput;
import com.order.entity.ProductInfo;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 9:16
 */
public interface ProductService {

    /**
     * 查询所有在架商品
     * @return
     */
    List<ProductInfo> findUpAllProduct();

    /**
     * 添加商品
     * @param productInfo
     */
    void insertProduct(ProductInfo productInfo);

    List<ProductInfo> findListById(List<String> pIds);

    void decreaseStockInput(String inputs);

    ProductInfo findProductById(String pId);
}
