package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext app = new AnnotationConfigApplicationContext(BeanConfig.class);


        Car car = (Car) app.getBean("car");
        car.run();
        System.out.println(car.bike);
        Bike b = (Bike) app.getBean("bike");
        b.run();
    }
}
