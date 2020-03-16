package com.order.exception;

import com.order.enums.ProductEnum;

/**
 * @Author: zhou
 * @Date: 2020/1/26 14:48
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(String message) {
        super(message);
    }

    public ProductException(ProductEnum productEnum){
        super(productEnum.getMsg());
        this.code = productEnum.getCode();
    }
}
