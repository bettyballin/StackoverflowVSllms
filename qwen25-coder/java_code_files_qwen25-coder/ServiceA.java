import java.lang.String;
import com.rabbitmq.client.*;

public class ServiceA {

    private final static String QUEUE_NAME = "service_b_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Declare the queue to ensure it exists
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                         AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                    // Process the message here
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);
        }
    }
}