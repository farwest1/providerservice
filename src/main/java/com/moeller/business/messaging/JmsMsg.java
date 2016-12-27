package com.moeller.business.messaging;

import com.moeller.common.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Created by Bernd on 25.12.2016.
 */
@Service
public class JmsMsg {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsMsg.class);

//    @Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
//    private static ConnectionFactory connectionFactory;

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:jboss/jms/ProviderTopic")
    private static Topic topic;

    public void sendMessage(Serializable msg){
        LOGGER.info("Publish new message");
        //connectionFactory.createContext().createProducer().send(topic, msg);
        context.createProducer().send(topic, msg );
    }
}
