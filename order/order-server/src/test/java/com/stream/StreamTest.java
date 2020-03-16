package com.stream;

import com.order.entity.Cart;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhou
 * @Date: 2020/1/26 20:54
 */
public class StreamTest {

    @Test
    public void test(){
        List<Cart> carts = new ArrayList<>();

        Cart cart = new Cart();
        cart.setProductId("123");
        cart.setProductQuantity("12");

        Cart cart1 = new Cart();
        cart1.setProductId("456");
        cart1.setProductQuantity("12");

        carts.add(cart);
        carts.add(cart1);

        List<String> collect = carts.stream().map(cart2 -> {
            return cart2.getProductId();
        }).collect(Collectors.toList());
        System.out.println(collect);

    }
}
