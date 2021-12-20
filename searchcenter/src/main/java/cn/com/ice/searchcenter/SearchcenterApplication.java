package cn.com.ice.searchcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SearchcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchcenterApplication.class, args);
    }

}
