package com.user.controller;

import com.common.utils.CookieUtil;
import com.common.vo.ResultVO;
import com.user.entity.UserInfo;
import com.user.enums.RoleEnum;
import com.user.enums.UserEnum;
import com.user.exception.UserException;
import com.user.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zhou
 * @Date: 2020/1/28 15:03
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;




    @GetMapping("findBuyByOpenId")
    @ResponseBody
    public ResultVO findBuyByOpenId(@RequestParam("openId")String openId, HttpServletResponse response){
        // 先根据openID查询出用户
        UserInfo userInfo = userService.findUserByOpenId(openId);
        // 判断用户是否存在
        if (userInfo==null) {
            return ResultVO.error(UserEnum.USER_NOT_EXIST.getValue());
        }
        // 判断用户角色
        if(! RoleEnum.USER_ROLE_BUY.getCode().equals(userInfo.getRole())){
            return ResultVO.error(RoleEnum.USER_ROLE_ERROR.getValue());
        }
        // 写入cookie
        CookieUtil.setCookie(response,"openId",userInfo.getOpen_id(),2*60*100);
        // 响应数据
        return ResultVO.success();
    }
    @GetMapping("findSellerByOpenId")
    @ResponseBody
    public ResultVO findSellerByOpenId(@RequestParam("openId")String openId, HttpServletResponse response){
        // 判断用户是否已登入，如果已登入，直接返回成功，避免重复写入cookie
        /**
         * 通过token获取value，再根据value去redis里查值，如果都不为空，证明已登入
         * 避免不停的向redis里写数据
         */
        UserInfo userInfo = userService.findUserByOpenId(openId);
        // 判断用户是否存在
        if (userInfo==null) {
            return ResultVO.error(UserEnum.USER_NOT_EXIST.getValue());
        }
        // 判断用户角色
        if(! RoleEnum.USER_ROLE_SELLER.getCode().equals(userInfo.getRole())){
            return ResultVO.error(RoleEnum.USER_ROLE_ERROR.getValue());
        }
        // 写入redis

        // 写入cookie
        CookieUtil.setCookie(response,"token",userInfo.getOpen_id(),2*60*100);
        // 响应数据
        return ResultVO.success();
    }

}
