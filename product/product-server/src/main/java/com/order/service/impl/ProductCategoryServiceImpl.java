package com.order.service.impl;

import com.order.entity.ProductCategory;
import com.order.mappers.CategoryMapper;
import com.order.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 10:37
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<ProductCategory> findAllCategory() {
        return categoryMapper.findAllCategory();
    }
}
