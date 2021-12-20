package cn.com.ice.goodscenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GoodscenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodscenterApplication.class, args);
    }

}
