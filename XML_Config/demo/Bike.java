package com.demo;

public class Bike implements Vehicle {
    private String brandName;
    Bike(){}
    Bike(String name){
        this.brandName = name ;
    }
    @Override
    public void run (){
        System.out.println("This is "+ brandName +"( Bike )");
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }
    public void getName(String name){
        System.out.println(this.brandName);
    }
}
