import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.jboss.jms.client.JBossConnectionFactory;

public class SendMessage {
    public static void main(String[] args) throws Exception {
        String queueName = "myQueue";
        String message = "Hello, World!";
        String url = "tcp://localhost:5445"; // replace with your JMS broker URL

        ConnectionFactory connectionFactory = new JBossConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        MessageProducer producer = session.createProducer(destination);
        TextMessage textMessage = session.createTextMessage(message);

        connection.start(); // start the connection before sending the message
        producer.send(textMessage);

        session.close();
        connection.close();
    }
}