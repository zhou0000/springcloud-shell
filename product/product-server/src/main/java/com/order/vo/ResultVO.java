package com.order.vo;

import lombok.Data;

/**
 * @Author: zhou
 * @Date: 2020/1/25 10:41
 */
@Data
public class ResultVO<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;


    public static <T> ResultVO success(T t){
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setData(t);
        return resultVO;
    }
}
