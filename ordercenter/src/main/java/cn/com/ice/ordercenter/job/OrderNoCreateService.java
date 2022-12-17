package cn.com.ice.ordercenter.job;

import cn.com.ice.ordercenter.aspect.ExclusiveLock;
import cn.com.ice.ordercenter.utils.RedisUtil;
import com.alibaba.nacos.common.utils.UuidUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 定时生成订单编号,缓存到redis中
 */
@Slf4j
@Component
public class OrderNoCreateService {
    /**
     * 配置分布式锁,保证同时间只有一个线程执行
     */
    @ExclusiveLock(keys="orderNoCreate",waitTime = 60,leaseTime = 60)
    @Scheduled(cron = "0 0 0 */1 * ?")
    public void createOrderNo() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(UuidUtils.generateUuid());
        }
        RedisUtil.lSet("OrderNo",list);
        log.info("createOrderNo");
    }
}
