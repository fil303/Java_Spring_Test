package com.demo;

public class Car {
    public String brandName;
    public String bike;
    Car(){}
    Car(String name){
        this.brandName = name ;
    }
    public void run (){
        System.out.println("This is "+ brandName +"( Car )");
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }
    public void setBike(String bike){
        this.bike = bike;
    }
    public void getName(String name){
        System.out.println(this.brandName);
    }
}
