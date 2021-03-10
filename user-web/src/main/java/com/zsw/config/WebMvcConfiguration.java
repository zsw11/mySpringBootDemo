package com.zsw.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zsw
 * @date 2021/2/1 17:04
 * @description : 拦截器  发现拦截器类，只能有一个，如果有定义了两个拦截器类，只有一个会生效 所以吧两个拦截器合并了
 */
//@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport{
    /*拦截swagger*/
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
