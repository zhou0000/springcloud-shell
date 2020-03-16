package com.order.mappers;

import com.order.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 9:21
 */
@Mapper
public interface ProductMapper {

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

    /**
     * 根据商品ID查找商品信息
     * @param pIds
     * @return
     */
    List<ProductInfo> findListById(@Param("pIds") List<String> pIds);

    ProductInfo findProductById(@Param("productId") String productId);

    void descStock(@Param("productId") String productId,@Param("productQuantity") Integer productQuantity);
}
