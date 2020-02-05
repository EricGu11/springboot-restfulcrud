package com.eric.config;

import com.eric.component.LoginInterceptor;
import com.eric.component.MyLocaleResolver;
import com.eric.entities.Employee;
import com.eric.filter.MyFilter;
import com.eric.listener.MyListener;
import com.eric.servlet.MyServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Set;

@Configuration
public class WebConfig implements WebMvcConfigurer {
/*    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }*/

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
            }
        };
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        *//**
         * 2.x springboot 依赖的是spring 5.x版本，
         * 使用自定义interceptor需要把静态资源和webjars的目录也exclude
         * excludePathPatterns中添加"/webjars/**"和"/asserts/**"
         *//*
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login.html", "/user/login","/webjars/**","/asserts/**");
    }*/

/*    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(Employee.class,new DateFormatter("yyyy-MM-dd"));
        registry.addFormatterForFieldType(Employee.class,new DateFormatter("yyyy.MM.dd"));
    }*/


/*    @Bean
    public TomcatServletWebServerFactory webServerFactoryCustomizer(){
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory(6666);
        tomcatServletWebServerFactory.setContextPath("/crud");
        return tomcatServletWebServerFactory;
    }*/

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet(),"/myservlet");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/","/hello","/myservlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }
}
