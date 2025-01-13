import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSExample {
    public static void main(String[] args) throws JMSException {
        // Producer
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("myQueue");
        MessageProducer producer = session.createProducer(destination);

        // Send a message
        String message = "Hello from JSP filter!";
        producer.send(session.createTextMessage(message));

        // Consumer
        MessageConsumer consumer = session.createConsumer(destination);

        // Receive messages
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("Received message: " + textMessage.getText());
                    } catch (JMSException e) {
                        // Handle exception
                    }
                }
            }
        });

        connection.start();
    }
}