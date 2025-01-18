package com.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.JoinPoint;

import java.util.ArrayList;
import java.util.List;

@Aspect
public class AssociationAspect {
    @After("call(void com.example.A.setB(com.example.B)) && args(b)")
    public void afterSetB(JoinPoint jp, B b) {
        A a = (A) jp.getTarget();
        b.getAs().add(a);
    }
    
    public static void main(String[] args) {
    }
}

class A {
    public void setB(B b) {
    }
}

class B {
    private List<A> as = new ArrayList<A>();

    public List<A> getAs() {
        return as;
    }
}