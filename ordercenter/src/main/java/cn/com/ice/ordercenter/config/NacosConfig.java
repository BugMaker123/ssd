package cn.com.ice.ordercenter.config;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.common.http.client.NacosRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class NacosConfig {


    @NacosInjected
    private NamingService namingService;

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

  /*  @Autowired
    private NacosRestTemplate nacosRestTemplate;*/

    /**
     * 注册服务
     *
     * @throws NacosException
     */
/*    @PostConstruct // 修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次！！！
    public void registerInstance() throws NacosException {
        namingService.registerInstance(applicationName, "192.168.230.101", serverPort);
    }*/


}
