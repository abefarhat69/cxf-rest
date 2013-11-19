package com.lagnada.demo.cxfrest.rest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.security.SecurityContext;

import java.security.Principal;

public class MyInterceptor extends AbstractPhaseInterceptor<Message> {

    public MyInterceptor() {
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        SecurityContext securityContext = (SecurityContext) message.get("org.apache.cxf.security.SecurityContext");
        Principal userPrincipal = securityContext.getUserPrincipal();
        "".toString();
    }
}
