package com.order.exception;

import com.order.enums.ResultEnum;

/**
 * @Author: zhou
 * @Date: 2020/1/26 21:21
 */
public class ProductException extends RuntimeException {

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }
}
