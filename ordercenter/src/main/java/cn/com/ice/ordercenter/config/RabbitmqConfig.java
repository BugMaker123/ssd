package cn.com.ice.ordercenter.config;


import cn.com.ice.ordercenter.config.callback.ProducerConfirmCallBackListener;
import cn.com.ice.ordercenter.config.callback.ProducerReturnCallBackListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RabbitmqConfig
 * 创建rabbitConfig步骤
 * 1.创建连接工厂
 * 2.创建交换机
 * 3.创建队列
 * 4.绑定队列与交换机
 * 5.创建rabbitTemplate
 */
@Configuration
public class RabbitmqConfig {

    public static final String USER = "guest";
    public static final String PASS = "guest";
    public static final String VHOST = "/";
    public static final String HOST = "192.168.230.101";
    public static final Integer PORT = 5672;
    public static final String exchangeName = "dyhExchange";
    public static final String queueName = "dyhQueue";
    public static final String routingkey = "DYH";


    @Autowired
    private ProducerConfirmCallBackListener confirmCallBackListener;

    @Autowired
    private ProducerReturnCallBackListener returnCallBackListener;


    @Bean
    public CachingConnectionFactory getConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(HOST);
        connectionFactory.setPort(PORT);
        connectionFactory.setUsername(USER);
        connectionFactory.setPassword(PASS);
        connectionFactory.setVirtualHost(VHOST);
        AcknowledgeMode acknowledgeMode = AcknowledgeMode.MANUAL;
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    /**
     * 配置交换机
     * @return
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName,true,false);
    }

    /**
     * 配置队列
     * @return
     */
    @Bean
    public Queue getQueue() {
        return new Queue(queueName,true);
    }

    /**
     * 绑定交换机和队列
     * @return
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(getQueue()).to(exchange()).with(routingkey);
    }

    /*@Bean("listenerContainerFactory")
    public RabbitListenerContainerFactory listenerContainerFactory(@Qualifier(value = "connectionFactory") ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        //最小消费者数量
        factory.setConcurrentConsumers(10);
        //最大消费者数量
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }*/

    /**
     * 创建rabbitTemplate
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(confirmCallBackListener);
        rabbitTemplate.setReturnCallback(returnCallBackListener);
        return rabbitTemplate;
    }

}
