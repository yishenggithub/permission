package com.mmall.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by easom on 2017/12/2.
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static <T>T popBean(Class<T> Clazz){
        if(applicationContext==null){
            return null;
        }
        return applicationContext.getBean(Clazz);
    }

    public static <T>T popBean(String name,Class<T> clazz){
        if(applicationContext==null){
            return null;
        }
        return applicationContext.getBean(name,clazz);
    }
}
