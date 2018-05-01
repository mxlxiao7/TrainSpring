package com.train.config;

import com.train.config.RootConfig;
import com.train.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 相当于web.xml
 */
public class SelfWebAppinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * @return
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * @return
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * @return
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
