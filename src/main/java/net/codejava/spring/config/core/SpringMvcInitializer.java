package net.codejava.spring.config.core;

import net.codejava.spring.config.ApplicationContextConfig;
import net.codejava.spring.config.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationContextConfig.class,};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SecurityConfig.class, SpringSecurityInitializer.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}