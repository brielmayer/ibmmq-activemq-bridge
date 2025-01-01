package com.brielmayer.jmsbridge.configuration;

import jakarta.jms.ConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.ibm.msg.client.jakarta.jms.JmsConstants.CLIENT_ACKNOWLEDGE;

@Configuration(proxyBeanMethods = false)
public class JmsComponentConfiguration {

    @Bean("ibmmq")
    public JmsComponent ibmMqComponent(ConnectionFactory ibmMQConnectionFactory) {
        JmsComponent jms = new JmsComponent();
        jms.setConnectionFactory(ibmMQConnectionFactory);
        jms.setDisableReplyTo(true);
        jms.setAcknowledgementMode(CLIENT_ACKNOWLEDGE);
        return jms;
    }

    @Bean("activemq")
    public JmsComponent activeMqComponent(ConnectionFactory activeMqConnectionFactory) {
        JmsComponent jms = new JmsComponent();
        jms.setConnectionFactory(activeMqConnectionFactory);
        return jms;
    }

}
