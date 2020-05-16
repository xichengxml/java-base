package com.xicheng.javabase.t02_idempotence.config;

import com.xicheng.javabase.t02_idempotence.interceptor.AutoIdempotentInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-05-16 23:02
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AutoIdempotentInterceptor()).addPathPatterns();
    }


}
