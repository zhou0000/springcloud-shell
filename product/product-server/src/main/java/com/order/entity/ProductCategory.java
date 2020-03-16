package com.order.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: zhou
 * @Date: 2020/1/25 10:32
 */
@Data
@ToString
public class ProductCategory {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
