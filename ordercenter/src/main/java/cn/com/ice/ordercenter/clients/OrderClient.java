package cn.com.ice.ordercenter.clients;

import cn.com.ice.ordercenter.common.ResultModel;
import cn.com.ice.ordercenter.enity.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "order-center",
        contextId="orderClient",
        fallback = OrderClientFallback.class,
        configuration = FeignClientProperties.FeignClientConfiguration.class
)
public interface OrderClient {

    @GetMapping("order/getOrderInfoById")
    ResultModel<OrderInfo> getOrderInfoById(@RequestParam Long id);

    @PostMapping("order/addOrder")
    ResultModel addOrderInfo(OrderInfo orderInfo);


}
