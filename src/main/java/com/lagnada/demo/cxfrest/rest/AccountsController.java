package com.lagnada.demo.cxfrest.rest;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Random;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Consumes({APPLICATION_JSON, APPLICATION_XML})
@Produces({APPLICATION_JSON, APPLICATION_XML})
@Service("accountsController")
public class AccountsController {

    @Context
    private UriInfo uriInfo;

    @POST
    @Path("/accounts")
    public Response createAccount(Account account) {
        Assert.notNull(account);
        Assert.isNull(account.getId(), "Account.id not allowed.");

        Long newAccountId = Long.valueOf(new Random().nextInt(1000));
        account.setId(newAccountId);
        URI newAccountUri = uriInfo.getBaseUriBuilder()
                .path("/account/{id}")
                .build(newAccountId);
        account.setSelf(newAccountUri);
        return Response.created(newAccountUri)
                .entity(account)
                .build();
    }

}
