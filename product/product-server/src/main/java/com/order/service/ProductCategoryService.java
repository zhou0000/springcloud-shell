package com.order.service;


import com.order.entity.ProductCategory;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 10:36
 */
public interface ProductCategoryService {

    List<ProductCategory> findAllCategory();
}
