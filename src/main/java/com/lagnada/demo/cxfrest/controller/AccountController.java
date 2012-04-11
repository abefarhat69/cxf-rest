package com.lagnada.demo.cxfrest.controller;

import org.joda.time.DateMidnight;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/account")
@Produces({"application/json"})
@Service("accountController")
public class AccountController {

    @GET
    @Path("/{id}")
    @RolesAllowed("hello")
    public Response getAccount(@PathParam("id") String id) {
        Account account = new Account();
        account.setUsername("john-doe");
        account.setFirstName("John");
        account.setLastName("Doe");
        Date birthDate = DateMidnight.now()
                .withYear(1999)
                .withMonthOfYear(1)
                .withDayOfMonth(21).toDate();
        account.setBirthDate(birthDate);
        account.setEnabled(true);
        return Response.ok(account).build();
    }


}
