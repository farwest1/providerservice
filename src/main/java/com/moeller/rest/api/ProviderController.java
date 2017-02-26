package com.moeller.rest.api;

import com.moeller.business.dao.ProviderRepository;
import com.moeller.business.domain.Provider;
import com.moeller.business.service.ProviderService;
import com.moeller.common.ExcpetionHandled;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
  @Consumes({"application/xml", "application/json"})
  @Produces({"application/xml", "application/json"})
  public Response addProvider (Provider provider) {
      LOGGER.debug("Add provider " + provider);
      providerService.saveProvider(provider);
      return Response.
          status(Status.CREATED).
          header("X-Frame-Options", "deny").
          header("X-Content-Type-Options", "nosniff").
          entity(provider).
          build();



  }


}
