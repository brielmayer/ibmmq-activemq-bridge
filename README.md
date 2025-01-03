# IBM MQ to ActiveMQ JMS Bridge

## Overview
This project is a simple JMS bridge that routes messages from an IBM MQ queue to an ActiveMQ queue using Apache Camel.

## Prerequisites

To run this application, you need:

- **Java 17 or higher**
- **Apache Maven**
- **IBM MQ server** with a configured queue
- **ActiveMQ server** with a configured queue

## Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/brielmayer/ibmmq-activemq-bridge.git
    cd ibmmq-activemq-bridge
    ```

2. Configure the application properties in `src/main/resources/application.properties`:
    ```properties
    ibmmq.queueManager=QM1
    ibmmq.channel=DEV.ADMIN.SVRCONN
    ibmmq.connName=localhost(1414)
    ibmmq.user=admin
    ibmmq.password=password

    activemq.broker-url=tcp://localhost:61616
    activemq.user=artemis
    activemq.password=artemis
    ```

3. Build the application:
    ```bash
    mvn clean package
    ```

4. Run the application:
    ```bash
    java -jar target/ibmmq-activemq-jms-bridge-1.0.jar
    ```

## How It Works

The application uses Apache Camel to:

1. Listen for messages on an IBM MQ queue (`DEV.QUEUE.1`).
2. Log the received messages.
3. Forward the messages to an ActiveMQ queue (`DEV.QUEUE.1`).

## Customization

To modify the routes, edit the `JmsBridgeRoute` class:
```java
@Component
public class JmsBridgeRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("ibmmq:queue:DEV.QUEUE.1")
                .log("Message received from IBM MQ: ${body}")
                .to("activemq:queue:DEV.QUEUE.1");
    }
}
```

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
