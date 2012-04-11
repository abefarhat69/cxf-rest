package com.lagnada.demo.cxfrest.filter;

import org.apache.cxf.interceptor.security.AbstractAuthorizingInInterceptor;
import org.apache.cxf.interceptor.security.AccessDeniedException;
import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.core.Response;

public class CustomSimpleAuthorizingFilter implements RequestHandler {

    private AbstractAuthorizingInInterceptor interceptor;

    public Response handleRequest(Message m, ClassResourceInfo resourceClass) {
        try {
            interceptor.handleMessage(m);
            return null;
        } catch (AccessDeniedException ex) {
            JSONObject json = new JSONObject();
            try {
                json.put("error", "access denied");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(json.toString())
                    .build();
        }
    }

    public void setInterceptor(AbstractAuthorizingInInterceptor in) {
        interceptor = in;
    }
}
