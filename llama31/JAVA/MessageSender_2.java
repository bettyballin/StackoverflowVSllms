import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender_2 {
    public static void main(String[] args) throws Exception {
        // Create a JMS connection
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = cf.createConnection();
        conn.start(); // Start the connection
        Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Set the message group ID and sequence number
        String messageGroupId = "my-group-id";
        int sequenceNumber = 1;
        Message msg = sess.createTextMessage("Hello, world!");
        msg.setStringProperty("JMSXGroupId", messageGroupId);
        msg.setIntProperty("JMSXGroupSeq", sequenceNumber);

        // Send the message
        MessageProducer prod = sess.createProducer(null);
        prod.send(msg);

        // Clean up
        sess.close(); // Close the session
        conn.close();
    }
}