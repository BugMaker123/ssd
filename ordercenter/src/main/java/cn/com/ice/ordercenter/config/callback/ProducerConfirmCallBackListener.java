package cn.com.ice.ordercenter.config.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * 针对消息没有到exchange,则触发此回调，比如路由不到队列
 * @ ClassName: ConfirmCallBackListener
 * @Author: legen
 * @Date: 2020/10/22
 */

@Service
public class ProducerConfirmCallBackListener implements RabbitTemplate.ConfirmCallback {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerConfirmCallBackListener.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        LOGGER.info("ConfirmCallback:     "+"相关数据："+correlationData);
        LOGGER.info("ConfirmCallback:     "+"确认情况："+ack);
        LOGGER.info("ConfirmCallback:     "+"原因："+cause);
        if(!ack){
            //可以进行日志记录、异常处理、补偿处理等
            LOGGER.error("异常处理....");
        }
    }
}
