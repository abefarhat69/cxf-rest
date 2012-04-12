package com.lagnada.demo.cxfrest.controller;

import org.joda.time.DateMidnight;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Date;

@Path("/account")
@Produces({"application/json"})
@Service("accountController")
public class AccountController {

    @GET
    @Path("/{id}")
    @RolesAllowed("ROLE_USER")
    public Response getAccount(@PathParam("id") Long id) {
        Account account = new Account();
        account.setId(id);
        account.setUsername("john-doe");
        account.setFirstName("John");
        account.setLastName("Doe");
        Date birthDate = DateMidnight.now()
                .withYear(1999)
                .withMonthOfYear(1)
                .withDayOfMonth(21).toDate();
        account.setBirthDate(birthDate);
        account.setEnabled(true);

        URI self = UriBuilder.fromUri("http://localhost:8080/api/account")
                .path(AccountController.class, "getAccount")
                .build(id);
        account.setSelf(self);

        return Response.ok(account).build();
    }


}
