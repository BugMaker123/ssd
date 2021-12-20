package cn.com.ice.usercenter.config;

import cn.com.ice.usercenter.common.constant.AppConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.util.Properties;

public class FeignConfig implements RequestInterceptor, EnvironmentAware {

    private String appName;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (StringUtils.isEmpty(appName)) {
            appName = getAppName();
        }
        requestTemplate.header(AppConstant.CLIENT_NAME_KEY, appName);
    }

    private String getAppName() {
        Properties properties = System.getProperties();
        if (StringUtils.isEmpty(appName)) {
            appName = properties.getProperty("application.name");
        }
        if (StringUtils.isEmpty(appName)) {
            appName = properties.getProperty("app.id");
        }
        if (StringUtils.isEmpty(appName)) {
            appName = properties.getProperty(AppConstant.CLIENT_NAME_KEY);
        }
        if (StringUtils.isEmpty(appName)) {
            appName = AppConstant.DEFAULT_APP_NAME;
        }
        return appName;
    }

    @Override
    public void setEnvironment(Environment environment) {
        appName = environment.getProperty("spring.application.name");
    }
}