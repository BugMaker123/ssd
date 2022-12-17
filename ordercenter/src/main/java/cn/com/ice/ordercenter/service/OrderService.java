package cn.com.ice.ordercenter.service;

import cn.com.ice.ordercenter.common.ResultModel;
import cn.com.ice.ordercenter.enity.OrderInfo;

public interface OrderService {

    ResultModel createOrder(OrderInfo orderInfo) ;
}
