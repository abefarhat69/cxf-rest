package com.lagnada.demo.cxfrest.controller;

import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces({"application/json", "application/xml"})
@Consumes({"application/json", "application/xml"})
@Service("accountsController")
public class AccountsController {

    @POST
    @Path("/accounts")
    public Response getAccount(Account account) {
        return Response.ok(account).build();
    }

}
