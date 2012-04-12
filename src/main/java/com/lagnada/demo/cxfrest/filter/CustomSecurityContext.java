package com.lagnada.demo.cxfrest.filter;

import org.apache.cxf.security.SecurityContext;

import java.security.Principal;

public class CustomSecurityContext implements SecurityContext {

    @Override
    public Principal getUserPrincipal() {
        return new Principal() {
            @Override
            public String getName() {
                return "johndoe";
            }
        };
    }

    @Override
    public boolean isUserInRole(String role) {
        if ("ROLE_USER".equals(role)) {
            return true;
        }
        return false;
    }
}
