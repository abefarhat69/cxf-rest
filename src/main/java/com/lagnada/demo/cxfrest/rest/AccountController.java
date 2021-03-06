package com.lagnada.demo.cxfrest.rest;

import org.joda.time.DateMidnight;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Date;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Path("/account")
@Produces({APPLICATION_JSON, APPLICATION_XML})
@Service("accountController")
public class AccountController {

    @Context
    private UriInfo uriInfo;

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

        account.setSelf(uriInfo.getRequestUri());

        return Response.ok(account).build();
    }


}
