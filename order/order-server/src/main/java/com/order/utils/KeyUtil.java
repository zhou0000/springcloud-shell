package com.order.utils;

import java.util.Random;

/**
 * @Author: zhou
 * @Date: 2020/1/27 10:35
 */
public class KeyUtil {

    /**
     * 生成唯一主键 ： 时间戳+随机数
     * @return
     */
    public static synchronized String genUniquerKey(){
        Random random = new Random();
        Integer number = random.nextInt(100)+9;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
