一：网关的使用
    1，引入依赖
    2，添加注解 @EnableZuulProxy
       此时就可以使用网关了
       http://localhost:8081/product/list  不适用网关，直接获取商品列表
       http://localhost:9000/product/product/list 使用网关获取商品列表
            第一个product是商品的服务名，/poroduct/list是商品列表的访问路径
       （此时还没有配置相关信息，配置好后不能直接商品服务，必须通过网关访问）
    3，配置路由
        zuul:
          routes:
        #    myProduct: 这个可以随便写
        #      path: /myProduct/** #请求路径以/myProduct/开头的都路由过来
        #      serviceId: product-server #服务名称
            product-server: /myProduct/** #简写
          ignored-patterns: #排除某些路径被路由，说白了就是外部（浏览器，postman）不能调用，只能服务间调用 patterns:值是一个集合
            - /myProduct/product/list   #此路径外界就不能访问了，报404  可以简写 /**/product/list
          sensitive-headers: #敏感头信息拦截，不填则不拦截，解决zuul无法获取cookie问题
二：查看所有的路由路径
    在运行日志中mapper route的相关信息
三：问题一
    使用zuul组件，前端cookie是不能传递给后端的
    看第十八行
四：zuul的四种过滤器
    1，前置过滤器(pre)
        场景： a,限流     b,鉴权      c,参数校验调整   d,请求分发
    2，后置过滤器（post) 请求执行完
        场景：可以做一些统计  执行时间  或者写入日志
    限流：令牌桶限流，令牌桶算法，有一个开源的组件，谷歌的