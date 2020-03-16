package com.order.service.impl;

import com.order.entity.ProductCategory;
import com.order.service.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 10:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Test
    public void findAllCategory() {
        List<ProductCategory> allCategory = productCategoryService.findAllCategory();
        for (ProductCategory productCategory : allCategory) {
            System.out.println(productCategory);
        }
    }
}