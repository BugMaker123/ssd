package cn.com.ice.ordercenter.controller;

import cn.com.ice.ordercenter.common.ResultModel;
import cn.com.ice.ordercenter.enity.OrderInfo;
import cn.com.ice.ordercenter.service.OrderService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @PostMapping("/createOrder")
    public ResultModel createOrder(@RequestBody OrderInfo orderInfo) {

        return orderService.createOrder(orderInfo);
    }
    /**
     * 取消订单--修改订单状态为取消
     */

    /**
     * 删除订单---修改订单状态为删除
     */
    @PostMapping("/deleteOrder")
    public ResultModel deleteOrder(@RequestBody OrderInfo orderInfo) {
        return null;
    }
    /**
     * 数据查询-根据订单编码查询订单信息
     * @param Id
     * @return
     */
    @GetMapping("order/getOrderInfoById")
    public ResultModel<OrderInfo> getOrderInfoById(Long Id) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(1000011L);
        orderInfo.setGoodInfo("北极体验卡");
        orderInfo.setCreateUserId("100001");
        orderInfo.setGoodInfo("非常nice的一次购物");
        orderInfo.setCreateUserName("Thomson");
        orderInfo.setCreateTime(new Date());
        return ResultModel.createSuccessResult(orderInfo);
    }

}
