package com.brielmayer.jmsbridge.configuration;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ActiveMqConfiguration {

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Value("${activemq.user}")
    private String user;

    @Value("${activemq.password}")
    private String password;

    @Bean
    public ConnectionFactory activeMqConnectionFactory() {
        return new ActiveMQConnectionFactory(user, password, brokerUrl);
    }

}
