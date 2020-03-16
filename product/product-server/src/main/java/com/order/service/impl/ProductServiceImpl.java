package com.order.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.entity.DecreaseStockInput;
import com.order.entity.ProductInfo;
import com.order.enums.ProductEnum;
import com.order.exception.ProductException;
import com.order.mappers.ProductMapper;
import com.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 9:18
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<ProductInfo> findUpAllProduct() {
        return productMapper.findUpAllProduct();
    }

    @Override
    public void insertProduct(ProductInfo productInfo) {
        productMapper.insertProduct(productInfo);
    }

    @Override
    public List<ProductInfo> findListById(List<String> pIds) {
        return productMapper.findListById(pIds);
    }

    @Override
    public ProductInfo findProductById(String pId) {
        return productMapper.findProductById(pId);
    }

    @Override
    public void decreaseStockInput(String inputs) {
        System.out.println("获取到的值："+inputs);
        /*for (DecreaseStockInput input : inputs) {
            ProductInfo productInfo = productMapper.findProductById(input.getProductId());
            // 判断商品是否存在
            if (null == productInfo) {
                throw new ProductException(ProductEnum.PRODUCT_NOT_EXIST);
            }
            // 判断库存是否够
            if (productInfo.getProductStock() < input.getProductQuantity()) {
                throw new ProductException(ProductEnum.PRODUCT_STACK_ERROR);
            }
            // 开始减库存
            productMapper.descStock(input.getProductId(),input.getProductQuantity());
        }*/
    }
}
