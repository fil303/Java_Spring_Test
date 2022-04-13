package org.example.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


public class WebInt extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Place MvcConfig and SecurityConfig to same ApplicationContext
        // see https://docs.spring.io/spring-security/site/docs/5.0.5.RELEASE/reference/htmlsingle/#mvc-requestmatcher
        System.out.println("webint Working....");
        return new Class[] { Web.class, Security.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[] { new SecurityFilter() };
//    }
}
