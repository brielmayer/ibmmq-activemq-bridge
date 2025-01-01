package com.brielmayer.jmsbridge.configuration;

import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import com.ibm.msg.client.jakarta.wmq.WMQConstants;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class IbmMqConfiguration {

    @Value("${ibmmq.queueManager}")
    private String queueManager;

    @Value("${ibmmq.channel}")
    private String channel;

    @Value("${ibmmq.connName}")
    private String connName;

    @Value("${ibmmq.user}")
    private String user;

    @Value("${ibmmq.password}")
    private String password;

    @Bean
    public ConnectionFactory ibmMQConnectionFactory() throws JMSException {
        MQConnectionFactory mqConnectionFactory = new MQConnectionFactory();
        mqConnectionFactory.setQueueManager(queueManager);
        mqConnectionFactory.setChannel(channel);
        mqConnectionFactory.setStringProperty(WMQConstants.WMQ_CONNECTION_NAME_LIST, connName);
        mqConnectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
        mqConnectionFactory.setStringProperty(WMQConstants.USERID, user);
        mqConnectionFactory.setStringProperty(WMQConstants.PASSWORD, password);
        return mqConnectionFactory;
    }

}
