package com.demo;

public class Car implements Vehicle {
    private String brandName;
    Car(){}
    Car(String name){
        this.brandName = name ;
    }
    @Override
    public void run (){
        System.out.println("This is "+ brandName +"( Car )");
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }
    public void getName(String name){
        System.out.println(this.brandName);
    }
}
