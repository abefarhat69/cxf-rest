package com.lagnada.demo.cxfrest.rest;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Random;

@Produces({"application/json"})
@Consumes({"application/json"})
@Service("accountsController")
public class AccountsController {

    @POST
    @Path("/accounts")
    public Response createAccount(Account account) {
        Assert.notNull(account);
        Assert.isNull(account.getId(), "Account.id not allowed.");

        Method getAccount = getMethod(AccountController.class, "getAccount", Long.class);
        Long newAccountId = Long.valueOf(new Random().nextInt(1000));
        account.setId(newAccountId);
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
