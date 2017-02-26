package com.moeller.business.messaging;

import com.google.gson.Gson;
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
        @ActivationConfigProperty(propertyName = "destinationLookup",propertyValue = "java:/topic/duke-topic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "LoopbackSubscriber"),
        @ActivationConfigProperty(propertyName = "clientId", propertyValue = "providersvcmdb"),
//        @ActivationConfigProperty(propertyName = "connectionFactoryLookup", propertyValue = "java:/artemisCF")

})

public class MyMessageListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyMessageListener.class);
    private static final Gson GSON = new Gson();

    @Override
    public void onMessage(Message message) {

        try {
            LOGGER.info("message received: ");
            LOGGER.info("CorrelationId: " + message.getJMSCorrelationID());
            String msg = message.getBody(String.class);
            Provider provider = GSON.fromJson(msg, Provider.class);
            LOGGER.info("Provider: " + provider);

        }catch(JMSException e){
            e.printStackTrace();
        }
    }
}
