package com.moeller.business.messaging;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Topic;

/**
 * Created by Bernd on 31.12.2016.
 */
@JMSDestinationDefinitions(
    value = {
        @JMSDestinationDefinition(
            name = "java:/topic/duke-topic",
            interfaceName = "javax.jms.Topic",
            destinationName = "duke-topic"
        )
    }
)
@Startup
@Singleton
public class JmsSetup {

  @Resource(lookup = "java:/topic/duke-topic")
  private Topic topic;

  @Produces
  public Topic expose(){
    return this.topic;
  }

}
