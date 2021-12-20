package cn.com.ice.ordercenter.clients;

import cn.com.ice.ordercenter.common.ResultModel;
import cn.com.ice.ordercenter.enity.OrderInfo;

public class OrderClientFallback implements OrderClient{

    @Override
    public ResultModel<OrderInfo> getOrderInfoById(Long id) {
        return ResultModel.createFailResult();
    }

    @Override
    public ResultModel addOrderInfo(OrderInfo orderInfo) {
        return ResultModel.createFailResult();
    }
}
