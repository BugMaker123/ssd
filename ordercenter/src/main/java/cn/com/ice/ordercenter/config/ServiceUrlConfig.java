//package cn.com.ice.ordercenter.config;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringApplicationRunListener;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.util.StringUtils;
//
//import java.util.Properties;
//
///**
// * @Author: Hamsun
// * @Date: 2020/12/10 11:44
// */
//
//public class ServiceUrlConfig implements SpringApplicationRunListener {
//    private final SpringApplication application;
//    private final String[] args;
//
//    private static String ORDERCENTER_SERVICE_URL_KEY = "orderCenterServiceUrl";
//
//    private static String ORDERCENTER_SERVICE_URL_DEFAULT = "http://192.168.230.101:9092/";
//
//
//    public ServiceUrlConfig(SpringApplication sa, String[] args) {
//        this.application = sa;
//        this.args = args;
//    }
//
//    @Override
//    public void starting() {
//        Properties properties = System.getProperties();
//        String orderCenterServiceUrl = properties.getProperty(ORDERCENTER_SERVICE_URL_KEY);
//        if(!StringUtils.isEmpty(orderCenterServiceUrl)){
//            return;
//        }
//        String env = properties.getProperty("env");
//        if(StringUtils.isEmpty(env)){
//            properties.setProperty(ORDERCENTER_SERVICE_URL_KEY, ORDERCENTER_SERVICE_URL_DEFAULT);
//        }else {
//            env = env.toLowerCase().trim();
//            if("dev".equals(env)||"uat".equals(env)){
//                properties.setProperty(ORDERCENTER_SERVICE_URL_KEY, ORDERCENTER_SERVICE_URL_DEFAULT);
//            }
//        }
//    }
//
//    @Override
//    public void environmentPrepared(ConfigurableEnvironment environment) {
//
//    }
//
//    @Override
//    public void contextPrepared(ConfigurableApplicationContext context) {
//
//    }
//
//    @Override
//    public void contextLoaded(ConfigurableApplicationContext context) {
//
//    }
//
//    @Override
//    public void started(ConfigurableApplicationContext context) {
//
//    }
//
//    @Override
//    public void running(ConfigurableApplicationContext context) {
//
//    }
//
//    @Override
//    public void failed(ConfigurableApplicationContext context, Throwable exception) {
//
//    }
//}
