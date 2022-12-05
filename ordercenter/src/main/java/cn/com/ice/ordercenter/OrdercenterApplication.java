package cn.com.ice.ordercenter;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

@EnableFeignClients(basePackages="cn.com.ice.ordercenter.*")
@EnableDiscoveryClient
@NacosConfigurationProperties(dataId = "order-center", autoRefreshed = true)
@SpringBootApplication
public class OrdercenterApplication {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private int serverPort;


    public static void main(String[] args) {
        SpringApplication.run(OrdercenterApplication.class, args);

    }
}

@Service
class SpringBootCallBackCommandLineRunner implements CommandLineRunner {
    @Value("${spring.redis.host}")
    private  String redisHost;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("redisHost:"+redisHost);
        System.out.println("SpringBootCallBackCommandLineRunner");
    }
}