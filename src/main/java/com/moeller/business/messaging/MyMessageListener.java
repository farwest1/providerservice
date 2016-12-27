package com.moeller.business.messaging;

import com.moeller.business.domain.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Bernd on 26.12.2016.
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",propertyValue = "java:jboss/jms/ProviderTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "LoopbackSubscriber")

})
public class MyMessageListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMessageListener.class);

    @Override
    public void onMessage(Message message) {

        try {
            LOGGER.info("message received: " + (Provider)message.getBody(Provider.class));

        }catch(JMSException e){
            e.printStackTrace();
        }
    }
}
