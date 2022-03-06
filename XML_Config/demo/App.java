package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext app = new ClassPathXmlApplicationContext("file:src/main/java/com/Beans.xml");
        Vehicle vehicle = (Vehicle) app.getBean("vehicle");
        vehicle.run();
    }
}
