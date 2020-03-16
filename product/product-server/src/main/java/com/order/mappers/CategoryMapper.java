package com.order.mappers;

import com.order.entity.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 10:34
 */
@Mapper
public interface CategoryMapper {

    /**
     * 查询所有的分类
     */
    List<ProductCategory> findAllCategory();
}
