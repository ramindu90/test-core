package org.mlcr.jobfind.database.jaxrs.api.implementation;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.mlcr.jobfind.database.jaxrs.api.Applicant;
import org.mlcr.jobfind.database.mgt.bean.Application;
import org.mlcr.jobfind.database.mgt.exception.DALException;
import org.mlcr.jobfind.database.mgt.impl.JobFindDataServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

//@Consumes({"application/json"})
//@Produces({"application/json"})
@SuppressWarnings("NonJaxWsWebServices")
@Path("/applicant")
public class ApplicantImplementation implements Applicant {
    final static Logger log = Logger.getLogger(ApplicantImplementation.class);
    private static final String ERROR_WHEN_REGISTERING_APPLICANT = "Error when registering the applicant.";

    @POST
    @Consumes("text/plain")
    //@Consumes({"application/json"})
    @Path("register")
    public Response registerApplicant(String applicationJsonString) {
        //TODO: Clarification: This was taken by the osgi service.. why? GadgetDataService gadgetDataService = (GadgetDataService) ctx.getOSGiService(GadgetDataService.class, null);
        JobFindDataServiceImpl jobFindDataServiceImpl = new JobFindDataServiceImpl();
        try {
            //Construct Application Object
            jobFindDataServiceImpl.registerApplicant(new Application());
        } catch (DALException e) {
            log.error("An internal error occurred while trying to execute relevant data service function " +
                    "@ Dashboard API layer to retrieve device counts by connectivity statuses.", e);
            return Response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).
                    entity(ERROR_WHEN_REGISTERING_APPLICANT).build();
        }
        return null;
    }
}
