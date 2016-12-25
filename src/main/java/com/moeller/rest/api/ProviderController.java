package com.moeller.rest.api;

import com.moeller.business.dao.ProviderRepository;
import com.moeller.business.domain.Provider;
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
public class ProviderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderController.class);

    @Inject
    private ProviderRepository providerRepository;

    @GET
    @Path("/{providerid}")
    @Produces({ "application/xml",
                "application/json"})
    public Provider getProvider(@PathParam("providerid") long id){
        return providerRepository.findProviderById(id);
    }

    @POST
    @Consumes({"application/json", "application/xml"})
    public void addProvider (Provider provider) {
        LOGGER.debug("Add provider " + provider);
        providerRepository.saveProvider(provider);
    }


}
