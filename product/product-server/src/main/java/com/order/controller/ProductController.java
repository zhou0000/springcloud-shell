package com.order.controller;

import com.order.entity.DecreaseStockInput;
import com.order.entity.ProductCategory;
import com.order.entity.ProductInfo;
import com.order.service.ProductCategoryService;
import com.order.service.ProductService;
import com.order.vo.ProductInfoVO;
import com.order.vo.ProductVO;
import com.order.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhou
 * @Date: 2020/1/25 8:38
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping("list")
    @ResponseBody
    public ResultVO<List<ProductVO>> findAllUpProduct(){

        List<ProductCategory> categories = productCategoryService.findAllCategory();

        List<ProductInfo> products = productService.findUpAllProduct();

        List<ProductVO> productVOs = new ArrayList<>();
        // 封装数据
        for (ProductCategory category : categories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            List<ProductInfoVO> productInfoVOS = new ArrayList<>();
            for (ProductInfo product : products) {
                System.out.println(category.getCategoryType() +":"+product.getCategoryType());
                if(category.getCategoryType().equals(product.getCategoryType()) ){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(product,productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOS(productInfoVOS);
            productVOs.add(productVO);
        }
        return ResultVO.success(productVOs);

    }

    /**
     * 获取商品列表，给订单调用
     * @param pIds
     * @return
     */
    @GetMapping("listForOrder")
    public List<ProductInfo>listForOrder(List<String> pIds){ // 注意：接受参数类型是RequestBody,所以要用post请求
        return productService.findListById(pIds);
    }

    @GetMapping("findProductById")
    public ProductInfo findProductById(String pId){
        return productService.findProductById(pId);
    }

    /**
     * 减库存，订单服务调用
     * @param inputs
     */
    @GetMapping("decreaseStock")
    @ResponseBody
    public void decreaseStockInput(@RequestParam("inputs") String inputs){

        productService.decreaseStockInput(inputs);
    }
}
