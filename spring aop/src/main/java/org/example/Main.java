package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String args[]){
        ApplicationContext config = new ClassPathXmlApplicationContext("file:src/beans.xml");
        About ab = config.getBean("about",About.class);
        System.out.println(ab.amount(1,1));
//        ab.error();
    }
}
