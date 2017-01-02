package com.moeller.rest.api;

import com.moeller.business.dao.ProviderRepository;
import com.moeller.business.domain.Provider;
import com.moeller.business.service.ProviderService;
import com.moeller.common.ExcpetionHandled;
import java.net.URI;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * Created by Bernd on 25.12.2016.
 */
@ApplicationScoped
@Path("/provider")
@ExcpetionHandled
public class ProviderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderController.class);

    @Inject
    private ProviderRepository providerRepository;

    @Inject
    private ProviderService providerService;

    @GET
    @Path("/{providerid}")
    @Produces({ "application/xml",
                "application/json"})
    public Provider getProvider(@PathParam("providerid") long id){
        return providerRepository.findProviderById(id);
    }

    @POST
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/xml", "application/json"})
    public Response addProvider (Provider provider) {
        LOGGER.debug("Add provider " + provider);
        providerService.saveProvider(provider);
        return Response.status(Status.CREATED).entity(provider).build();

    }


}
