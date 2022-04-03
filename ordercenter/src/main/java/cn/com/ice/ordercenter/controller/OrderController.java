package cn.com.ice.ordercenter.controller;

import cn.com.ice.ordercenter.common.ResultModel;
import cn.com.ice.ordercenter.enity.OrderInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController {

    @GetMapping("order/getOrderInfoById")
    public ResultModel<OrderInfo> getOrderInfoById(Long Id) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(1000011L);
        orderInfo.setGoodInfo("北极体验卡");
        orderInfo.setCreateUserId("100001");
        orderInfo.setEvaluate("非常nice的一次购物");
        orderInfo.setCreateUserName("Thomson");
        orderInfo.setCreateTime(new Date());
        return ResultModel.createSuccessResult(orderInfo);
    }
}
