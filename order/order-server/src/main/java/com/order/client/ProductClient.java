package com.order.client;

import com.order.api.ProductApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: zhou
 * @Date: 2020/1/26 19:43
 */
@FeignClient("product-server")
public interface ProductClient extends ProductApi {
}
