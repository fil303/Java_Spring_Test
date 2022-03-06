package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Car car(@Qualifier("bike") Bike b){
        Car c = new Car("Marsitic");
    //  c.setBrandName("BMW");
        c.setBike(b.brandName);
        return c;
    }
    @Bean
    public Bike bike(){
        Bike c = new Bike("Osaka");
       // c.setBrandName("Sport");
       // c.setCar(b.brandName);
        return c;
    }
}
