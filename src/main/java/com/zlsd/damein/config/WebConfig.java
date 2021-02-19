package com.zlsd.damein.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @program: damein
 * @description:
 * @author: lidongmin
 * @create: 2021-02-19 15:06
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private FangshuaInterceptor interceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }

}