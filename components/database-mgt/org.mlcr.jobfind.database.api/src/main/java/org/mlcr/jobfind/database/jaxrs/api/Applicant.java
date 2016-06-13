package org.mlcr.jobfind.database.jaxrs.api;

/**
 * Created by Ramindu on 6/5/16.
 */
import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/applicant")
//@Api(value = "vacancy", description = "Applicant related operations are described here.")
public interface Applicant {
    @POST
    @Path("register")
    Response registerApplicant(String applicationJsonString);
}
