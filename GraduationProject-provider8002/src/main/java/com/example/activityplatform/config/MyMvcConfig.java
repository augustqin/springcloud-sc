package com.example.activityplatform.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;





//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {




    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

            @Override
           public void addResourceHandlers(ResourceHandlerRegistry registry) {
                //将所有/static/** 访问都映射到classpath:/static/ 目录下
                registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
                registry.addResourceHandler("/upload/*").addResourceLocations("file:D:\\upload\\");
            }

           @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //registry.addViewController("UserBackHome").setViewName("pages/back/UserBackHome");
                registry.addViewController("PublishedAct").setViewName("pages/back/PublishedAct");
                //registry.addViewController("InsertActPage").setViewName("pages/back/InsertAct");
            }


            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
            }
        };
        return adapter;
    }


}
