package com.lagnada.demo.cxfrest.rest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAdvice {

    @Before("com.lagnada.demo.cxfrest.rest.ControllerAspect.inControllerMethod()")
    //@Before("execution(* com.lagnada.demo.cxfrest.*.*(..))")
    public void doAccessCheck() {
        "".toString();
    }

}
