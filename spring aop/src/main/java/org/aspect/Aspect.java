package org.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.example.Exceptionss;

@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Before("execution(* org.example.About.hello())")
    public void hello(){
        System.out.println("Israfil");
    }

    @After("execution(* org.example.About.say(..))")
    public void say(){
        System.out.println("Israfil Say");
    }

    @AfterThrowing(pointcut = "execution(* org.example.About.error())", throwing = "e")
    public void error(Exceptionss e){
        System.out.println(e+" From aspect");
    }



    @Around("execution(* org.example.About.amount(int,int))")
    public Object around(ProceedingJoinPoint jp){
        Object[] obj = jp.getArgs();
        obj[0] = 2;
        obj[1] = 2;
        Object proceed = null ;
        try {
            proceed = jp.proceed(obj);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return proceed;
    }
}
