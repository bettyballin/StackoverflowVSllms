import com.sonicbroker.MessageProducer;
import com.sonicbroker.Session;
import com.sonicbroker.Connection;
import com.sonicbroker.Destination;
import com.sonicbroker.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.TextMessage;

public class SonicMQPublisher {

    public static void main(String[] args) {
        String brokerHost = "your_broker_host"; // Replace with your broker host
        String brokerPort = "your_broker_port"; // Replace with your broker port
        String username = "your_username";     // Replace with your username
        String password = "your_password";     // Replace with your password
        String queueName = "your_queue_name";  // Replace with your queue name

        ConnectionFactory cf = null;
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;

        try {
            // Initialize SonicMQ ConnectionFactory
            cf = new com.sonicbroker.ConnectionFactory(
                    brokerHost, Integer.parseInt(brokerPort), username, password);

            // Establish a connection to the broker
            connection = cf.createConnection(username, password);
            connection.start();

            // Create a session within the connection
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Look up or create the destination queue
            Destination queue = session.createQueue(queueName);

            // Create a MessageProducer to send messages to the queue
            producer = session.createProducer(queue);

            // Create and send a TextMessage
            TextMessage message = session.createTextMessage("Hello, SonicMQ!");
            producer.send(message);
            System.out.println("Message sent: " + message.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (producer != null) producer.close();
                if (session != null) session.close();
                if (connection != null) connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}