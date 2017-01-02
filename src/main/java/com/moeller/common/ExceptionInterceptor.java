package com.moeller.common;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Response;

/**
 * Created by Bernd on 02.01.2017.
 *
 * Package com.moeller.common
 *
 *  Copied from https://jaxenter.de/wie-man-ein-zentralisiertes-rest-api-exception-handling-mit-beanvalidation-kombiniert-24427
 *  Central exception handling
 */
@ExcpetionHandled
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class ExceptionInterceptor {

  @AroundInvoke
  public Object handleException(InvocationContext context) {

    Object proceedResponse;

    try {
      proceedResponse = context.proceed();
    } catch (Exception ex) {
      return Response.serverError().entity(ex.getMessage()).build();
    }
    return proceedResponse;
  }

}
