package com.zsw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @author zsw
 * @date 2021/3/9 16:09
 * @description : 注册拦截器 springboot1.x 实现拦截器是继承WebMvcConfigurerAdapter springboot 2.x实现拦截器是 实现 WebMvcConfigurer 接口,
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Resource
    private MyIntercept myIntercept;

    //注册拦截器 拦截请求 目前不使用
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //SpringMVC下，拦截器的注册需要排除对静态资源的拦截(*.css,*.js)2
        // SpringBoot已经做好了静态资源的映射，因此我们无需任何操作
//        registry.addInterceptor(myIntercept).addPathPatterns("/**")
//                .excludePathPatterns("/error","/static/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }


}
