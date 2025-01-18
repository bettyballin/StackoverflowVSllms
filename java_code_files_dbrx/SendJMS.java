import javax.jms.*;
import java.util.HashMap;
import java.util.Map;
import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.api.jms.JMSFactoryType;
import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;
import org.hornetq.core.remoting.impl.netty.TransportConstants;
import org.hornetq.jms.client.HornetQConnectionFactory;

public class SendJMS {
    public static void main(String[] args) throws JMSException, InterruptedException {
        // Create a ConnectionFactory
        Map<String, Object> connectionParams = new HashMap<String, Object>();
        connectionParams.put(TransportConstants.HOST_PROP_NAME, "192.0.2.1");
        connectionParams.put(TransportConstants.PORT_PROP_NAME, 5445);

        TransportConfiguration transportConfig = new TransportConfiguration(NettyConnectorFactory.class.getName(), connectionParams);

        HornetQConnectionFactory connectionFactory = HornetQJMSClient.createConnectionFactoryWithoutHA(JMSFactoryType.CF, transportConfig);

        // Create a Connection
        Connection connection = connectionFactory.createConnection();
        try {
            // Start the Connection
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = HornetQJMSClient.createQueue("jms/queue/exampleQueue");
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setText("This is a text message");
            // And we send it
            producer.send(message);
        } finally {
            connection.close();
        }
    }
}