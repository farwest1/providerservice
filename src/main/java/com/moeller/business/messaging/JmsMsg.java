package com.moeller.business.messaging;

import com.moeller.common.Service;
import java.io.Serializable;
import java.util.UUID;
import javax.annotation.Resource;
import javax.inject.Inject;
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

//    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
//    private static ConnectionFactory connectionFactory;

    @Inject
//      @JMSConnectionFactory("java:/jms/remoteCF")
    private JMSContext context;

    @Inject
    private Topic topic;

    public void sendMessage(Serializable msg){
        LOGGER.info("Publish new message");
        //connectionFactory.createContext().createProducer().send(topic, msg)

        context.createProducer().setJMSCorrelationID(UUID.randomUUID().toString()).send(topic, msg);
    }


}
