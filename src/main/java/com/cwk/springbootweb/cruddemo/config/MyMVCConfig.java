package com.cwk.springbootweb.cruddemo.config;

import com.cwk.springbootweb.cruddemo.component.LoginIntercepter;
import com.cwk.springbootweb.cruddemo.component.SwichLanguage;
import com.cwk.springbootweb.cruddemo.filter.MyFilter;
import com.cwk.springbootweb.cruddemo.listener.Mylistener;
import com.cwk.springbootweb.cruddemo.servlet.MyServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;


@Configuration
public class MyMVCConfig implements WebMvcConfigurer {


    private static Logger logger = LoggerFactory.getLogger(MyMVCConfig.class);


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    @Bean
    public LocaleResolver localeResolver() {
        return new SwichLanguage();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login").excludePathPatterns("/webjars/**","/asserts/**");

    }

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new
                MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<Mylistener> registrationBean = new
                ServletListenerRegistrationBean<Mylistener>(new Mylistener());
        return registrationBean;
    }


    //    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**/favicon.ico").addResourceLocations("classpath:/public/");
//    }


/*    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new HandlerInterceptor(){
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                logger.info("ddddddddddddddddddddddddd++++++++++++++++++++++++++");
                logger.info(request.getContextPath()+"    "+request.getRequestURI());
                return false;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

            }
        }).addPathPatterns("/**");

    }*/
}
