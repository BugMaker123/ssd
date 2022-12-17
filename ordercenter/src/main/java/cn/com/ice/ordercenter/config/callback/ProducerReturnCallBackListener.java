package cn.com.ice.ordercenter.config.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * 针对消息没有到exchange,则触发此回调，比如路由不到队列
 * @ ClassName: ReturnCallBackListener
 * @Author: legen
 * @Date: 2020/10/22
 */

@Service
public class ProducerReturnCallBackListener implements RabbitTemplate.ReturnCallback {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerReturnCallBackListener.class);

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

        LOGGER.info("ReturnCallback:     "+"消息："+message);
        LOGGER.info("ReturnCallback:     "+"回应码："+replyCode);
        LOGGER.info("ReturnCallback:     "+"回应信息："+replyText);
        LOGGER.info("ReturnCallback:     "+"交换机："+exchange);
        LOGGER.info("ReturnCallback:     "+"路由键："+routingKey);
    }
}
