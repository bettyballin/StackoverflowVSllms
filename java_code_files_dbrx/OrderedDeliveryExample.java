import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class OrderedDeliveryExample {
    /* Example showing how one could design an ordered delivery using RabbitMQ */
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            /* Create a queue, with "ordered delivery" feature enabled: */
            Map<String, Object> argsMap = new HashMap<>();
            argsMap.put(QueueConstants.ARG_X_ORDERED, true); // Enable ordered messaging
            String queueName = channel.queueDeclare("myQueue", true, false, false, argsMap).getQueue();
        } catch (IOException | TimeoutException ex) {
            System.err.println("Error: " + ex);
        }
    }
}

class QueueConstants {
    public static final String ARG_X_ORDERED = "x-ordered";
}