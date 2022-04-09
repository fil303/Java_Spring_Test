package org.example;
import org.example.Exceptionss;
public class About {
    private String name;

    public About() {}
    public About(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello(){
        System.out.println("Hello Israfil Hossain");
    }
    public void say(String name){
        System.out.println("By Say");
        System.out.println("Hello "+name);
    }

    public void error()  {
        throw new Exceptionss("This is a exception");
    }

    public int amount(int a, int b){
        int d = (a*b) * 5;
        return d;
    }
}
