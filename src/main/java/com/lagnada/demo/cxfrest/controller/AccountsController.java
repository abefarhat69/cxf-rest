package com.lagnada.demo.cxfrest.controller;

import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.lang.reflect.Method;
import java.net.URI;

@Produces({"application/json", "application/xml"})
@Consumes({"application/json", "application/xml"})
@Service("accountsController")
public class AccountsController {

    @POST
    @Path("/accounts")
    public Response getAccount(Account account) {
        Method getAccount = getMethod(AccountController.class, "getAccount", String.class);
        URI newAccountUri = UriBuilder.fromResource(AccountController.class)
                .path(getAccount)
                .build(1);
        return Response.created(newAccountUri)
                .entity(account)
                .build();
    }

    private Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        try {
            return clazz.getMethod(methodName, parameterTypes);
        } catch (Exception e) {
            throw (new RuntimeException(e));
        }
    }

}
