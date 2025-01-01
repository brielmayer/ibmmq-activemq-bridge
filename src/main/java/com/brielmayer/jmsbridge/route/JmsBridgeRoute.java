package com.brielmayer.jmsbridge.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class JmsBridgeRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("ibmmq:queue:DEV.QUEUE.1")
                .log("Message received from IBM MQ: ${body}")
                .to("activemq:queue:DEV.QUEUE.1");
    }
}
