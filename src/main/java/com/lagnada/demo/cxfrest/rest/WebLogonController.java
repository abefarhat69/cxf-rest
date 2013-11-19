package com.lagnada.demo.cxfrest.rest;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/web-logon")
@Produces(APPLICATION_JSON)
@Service("webLogonController")
public class WebLogonController {

    @Context
    private Request request;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("/{id}")
    public Response getWebLogon(@PathParam("id") Long id) throws Exception {
        String method = request.getMethod();
        System.out.printf("method: %s%n", method);

        WebLogon webLogon = new WebLogon();
        webLogon.setUsername("johndoe");
        webLogon.setEmail("johndoe@yahoo.com");
        webLogon.setPassword("password");
        webLogon.setNotes("notes");
        webLogon.setUrl(new URI("http://www.yahoo.com"));

        URI self = uriInfo.getRequestUri();
        webLogon.setSelf(self);
        return Response.ok(webLogon)
                .build();
    }
}
