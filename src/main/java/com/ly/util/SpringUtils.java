package com.ly.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created by cilu on 2017/10/24.
 */

@Service
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
    }

    public static <T> T getBeanOfType(Class<T> clzz) {

        return applicationContext.getBean(clzz);
    }

    public static Object getBeanOfName(String name) {
        return applicationContext.getBean(name);
    }


    public static void register(Object object, String name) {
//        applicationContext.getAutowireCapableBeanFactory().autowireBeanProperties(object, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
        System.out.println(applicationContext.getParentBeanFactory());
        System.out.println(applicationContext.getAutowireCapableBeanFactory());
        System.out.println(applicationContext.getAutowireCapableBeanFactory());

    }

}
