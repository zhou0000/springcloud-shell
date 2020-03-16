package com.order.mapper;

import com.order.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zhou
 * @Date: 2020/1/27 10:42
 */
@Mapper
public interface OrderDetailMapper {

    void create(OrderDetail orderDetail);
}
