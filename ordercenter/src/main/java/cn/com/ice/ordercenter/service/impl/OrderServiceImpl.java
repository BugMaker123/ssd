package cn.com.ice.ordercenter.service.impl;

import cn.com.ice.ordercenter.common.ResultModel;
import cn.com.ice.ordercenter.enity.OrderInfo;
import cn.com.ice.ordercenter.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private RedissonClient redissonClient;

    @Override
    public ResultModel createOrder(OrderInfo orderInfo) {
        RLock lock = redissonClient.getLock("order");
        try {
            lock.tryLock(10, 10, TimeUnit.SECONDS);
            System.out.println("获取锁成功");
            //TODO 创建订单
            // 1.校验库存
            // 2.创建订单
            // 3.扣减库存
            // 4.发送消息
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}


