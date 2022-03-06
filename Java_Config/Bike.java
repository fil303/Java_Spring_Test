package com.demo;

public class Bike{
    public String brandName;
    public  String car;
    Bike(){}
    Bike(String name){
        this.brandName = name ;
    }

    public void run (){
        System.out.println("This is "+ brandName +"( Bike )");
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }
    public void setCar(String car){
        this.car = car;
    }
    public void getName(String name){
        System.out.println(this.brandName);
    }
}
