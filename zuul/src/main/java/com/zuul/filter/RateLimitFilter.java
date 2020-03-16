package com.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.zuul.exception.RateFilterException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @Author: zhou
 * @Date: 2020/1/28 13:36
 */
@Component
public class RateLimitFilter extends ZuulFilter {

    // 令牌桶组件：以固定的速率往令牌桶里放令牌，如果令牌桶放满了，就不放了直接调用。
    // 请求过来，先从令牌桶里获取令牌，如果获取到令牌了就放行，如果没有获取到令牌就拒绝请求
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);// 每秒向桶里放入一百个令牌

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1; //优先级应该是最高(找出最低的减1)
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 没有拿到令牌
        if(! RATE_LIMITER.tryAcquire()){
            throw new RateFilterException();
        }
        return null;
    }
}
