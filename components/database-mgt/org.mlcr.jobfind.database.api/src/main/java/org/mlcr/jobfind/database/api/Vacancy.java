package org.mlcr.jobfind.database.api;

/**
 * Created by Ramindu on 6/5/16.
 */
import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/vacancy")
//@Api(value = "vacancy", description = "Vacancy related operations are described here.")
public interface Vacancy {
    @GET
    @Path("vacancy-count-overview")
    Response getOverviewInterviewCounts();
}
