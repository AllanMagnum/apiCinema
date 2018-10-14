package br.com.verx.virtualstore.infra.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Class comments go here...
 *
 * @author José Carlos Mazella Junior
 * @version 1.0 10/10/2018
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public synchronized void setApplicationContext(final ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }

    public static <T> T getBean(final Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static Object getBean(final String name) {
        return applicationContext.getBean(name);
    }

}
