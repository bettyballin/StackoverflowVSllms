// MoM example using JMS (Java Message Service)
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MoMExample {
    public static void main(String[] args) throws Exception {
        // Create a JMS connection and session
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = cf.createConnection();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create a destination (queue or topic) and message producer
        Destination dest = session.createQueue("myQueue");
        MessageProducer producer = session.createProducer(dest);

        // Send a message
        TextMessage msg = session.createTextMessage("Hello, world!");
        producer.send(msg);

        // Clean up
        session.close();
        conn.close();
    }
}

// ESB example using Apache Camel
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class ESBExample {
    public static void main(String[] args) throws Exception {
        // Create a Camel context and route
        CamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:hello")
                .to("http://localhost:8080/hello");
            }
        });

        // Start the Camel context
        ctx.start();

        // Send a message
        ctx.getProducerTemplate().sendBody("direct:hello", "Hello, world!");

        // Clean up
        ctx.stop();
    }
}