package com.order.service.impl;

import com.order.entity.ProductInfo;
import com.order.mappers.ProductMapper;
import com.order.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 9:31
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;
    @Test
    public void findUpAllProduct() {
        List<ProductInfo> products = productService.findUpAllProduct();
        for (ProductInfo product : products) {
            System.out.println(product);
        }
    }
    @Test
    public void insertProduct(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1575377470579");
        productInfo.setProductName("冰淇淋");
        productInfo.setProductPrice(new BigDecimal(3.00));
        productInfo.setProductStock(15);
        productInfo.setProductDescription("冬天吃，够冰爽。。。");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        productInfo.setCreateTime(new Date());
        productInfo.setUpdateTime(new Date());

        productService.insertProduct(productInfo);

    }

    @Test
    public void findListById(){
        List<String> pids = Arrays.asList("1575377470578","1575377470579","1575377470572");
        List<ProductInfo> productInfos = productService.findListById(pids);
        for (ProductInfo productInfo : productInfos) {
            System.out.println(productInfo);
        }
    }

    @Test
    public void findProductById(){
        ProductInfo product = productMapper.findProductById("157537747057");
        System.out.println(product);
    }
    @Test
    public void descProductStock(){
        productMapper.descStock("1575377470578",2);
    }


}