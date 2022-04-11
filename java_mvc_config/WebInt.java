package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInt extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Place MvcConfig and SecurityConfig to same ApplicationContext
        // see https://docs.spring.io/spring-security/site/docs/5.0.5.RELEASE/reference/htmlsingle/#mvc-requestmatcher
        return new Class[] {Web.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
