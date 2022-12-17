package cn.com.ice.ordercenter.config.callback;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * 针对消费者定义ack机制
 */
@Component
public class ConsumerAckListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        String queue = message.getMessageProperties().getConsumerQueue();
        String msg = new String(message.getBody());
        // 获取消息id
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        // 业务处理
        System.out.println("queue:" + queue + ",msg:" + msg);
        // 手动ack
        try{
            // false表示只确认当前一个消息收到，true表示确认所有consumer获得的消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            // 消息处理失败，requeue属性为true重新放回队列(后面继续接收消息),为false则丢弃
            channel.basicNack(deliveryTag, true, true);
        }
    }
}
