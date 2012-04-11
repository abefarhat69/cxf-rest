package com.lagnada.demo.cxfrest.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//@Component
public class ControllerAspect {

    @Pointcut("@annotation(javax.ws.rs.Path)")
    public void inControllerMethod() {}

}
