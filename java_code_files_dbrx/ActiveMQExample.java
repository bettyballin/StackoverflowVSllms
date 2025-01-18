import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Message;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class ActiveMQExample {

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        ActiveMQQueue queue = new ActiveMQQueue("myqueue?consumer.prefetchSize=1&selector=JMSXGroupID=someId");

        // Producer
        Connection producerConn = connectionFactory.createConnection();
        producerConn.start();
        Session prodSession = producerConn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = prodSession.createProducer(queue);

        // Send messages
        TextMessage message1 = prodSession.createTextMessage("This is message 1");
        message1.setStringProperty("JMSXGroupID", "someId");
        producer.send(message1); // This and subsequent messages will be grouped together with the same someId

        // Similarly send other messages here, remember to set their JMSXGroup property accordingly for sequential processing
        TextMessage message2 = prodSession.createTextMessage("This is message 2");
        message2.setStringProperty("JMSXGroupID", "someId");
        producer.send(message2);

        // Close producer resources
        producer.close();
        prodSession.close();
        producerConn.close();

        // Consumer Thread
        Connection consumerConn = connectionFactory.createConnection();
        consumerConn.start();
        Session consSession = consumerConn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        ConsumerThreaded consumer1 = new ConsumerThreaded("Consumer-1", queue, connectionFactory); // This will form part of the same sub-queue (JMSXGroup selector)
        consumer1.start(); // Run this thread along with other threads and messages processing as required in your application context.

        // Allow some time for the consumer to process messages
        Thread.sleep(5000);

        // Clean up consumer resources
        consumer1.interrupt();
        consumer1.join();
        consSession.close();
        consumerConn.close();
    }
}

class ConsumerThreaded extends Thread {
    private String name;
    private Destination destination;
    private ConnectionFactory connectionFactory;

    public ConsumerThreaded(String name, Destination destination, ConnectionFactory connectionFactory) {
        this.name = name;
        this.destination = destination;
        this.connectionFactory = connectionFactory;
    }

    public void run() {
        Connection conn = null;
        Session session = null;
        MessageConsumer consumer = null;

        try {
            conn = connectionFactory.createConnection();
            conn.start();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            consumer = session.createConsumer(destination);

            while (!Thread.currentThread().isInterrupted()) {
                Message messageReceived = consumer.receive(1000);
                if (messageReceived != null) {
                    if (messageReceived instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) messageReceived;
                        System.out.println(name + " received: " + textMessage.getText());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (consumer != null) consumer.close();
                if (session != null) session.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}