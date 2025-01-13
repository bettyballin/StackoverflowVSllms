import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
    public static void main(String[] args) throws Exception {
        // Add a message to the queue
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("email.queue");
        MessageProducer producer = session.createProducer(queue);
        TextMessage message = session.createTextMessage("email data");
        producer.send(message);
        connection.close();
    }
}