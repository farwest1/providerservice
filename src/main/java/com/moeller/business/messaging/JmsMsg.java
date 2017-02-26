package com.moeller.business.messaging;

import com.google.gson.Gson;
import com.moeller.business.domain.Provider;
import com.moeller.common.Service;
import java.io.Serializable;
import java.util.UUID;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Bernd on 25.12.2016.
 */
@Service
public class JmsMsg {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsMsg.class);
    private static final Gson GSON = new Gson();

//    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
//    private static ConnectionFactory connectionFactory;

    private JMSContext context;

    private Topic topic;

    public JmsMsg(){

    }

    @Inject
    //public JmsMsg(@JMSConnectionFactory("java:/artemisCF") JMSContext jmsContext, Topic topic) {
    public JmsMsg(@JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory") JMSContext jmsContext, Topic topic) {
        this.context = jmsContext;
        this.topic = topic;
    }

    public void publishProviderChg(Provider provider){
        LOGGER.info("Publish new message");
        //connectionFactory.createContext().createProducer().send(topic, msg)
        String msg = GSON.toJson(provider);

        context.createProducer().setJMSCorrelationID(UUID.randomUUID().toString()).send(topic, msg);
    }


}
