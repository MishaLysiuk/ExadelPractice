package com.exadel.eventapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void run(){
        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
    }
}
