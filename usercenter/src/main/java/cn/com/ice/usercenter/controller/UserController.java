package cn.com.ice.usercenter.controller;

import cn.com.ice.ordercenter.clients.OrderClient;
import cn.com.ice.ordercenter.common.ResultCode;
import cn.com.ice.ordercenter.common.ResultModel;
import cn.com.ice.ordercenter.enity.OrderInfo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private OrderClient orderClient;

    @GetMapping("getUserInfoById")
    public String getUserInfoById(Long id){
        ResultModel<OrderInfo> orderInfo = orderClient.getOrderInfoById(10l);
        System.out.println(JSON.toJSON(orderInfo));
        return "HHHHH";
    }
    /**
     * 下单
     */
    @GetMapping("buyGoods")
    public ResultModel buyGoods(OrderInfo orderInfo){
        ResultModel resultModel = orderClient.addOrderInfo(orderInfo);
        if (resultModel.getCode().equals(ResultCode.SUCCESS.getCode())){
            return resultModel;
        }
        return ResultModel.createSuccessResult(resultModel);
    }
}
