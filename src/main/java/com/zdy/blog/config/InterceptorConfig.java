package com.zdy.blog.config;

import com.zdy.blog.interceptor.RegisterInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    String[] addPathPatterns = {
        "/login/**","/admin/**"
    };

    String[] excludePathPatterns = {
        "/login/interceptor","/login/index","/login/userLogin","/login/userRegister"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RegisterInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}

