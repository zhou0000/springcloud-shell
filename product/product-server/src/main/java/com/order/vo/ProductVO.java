package com.order.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 10:45
 */
@Data
public class ProductVO {

    /**
     * 分类名称
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 商品分类类型
     */
    @JsonProperty("type")
    private Integer categoryType;

    /**
     *  某分类下的所有商品信息
     */
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOS;
}
