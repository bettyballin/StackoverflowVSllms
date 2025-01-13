import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class RabbitMqProducerConsumer {
    public static void main(String[] args) throws Exception {
        // Producer
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection("amqp://localhost");
        Channel channel = connection.createChannel();

        String exchangeName = "my_exchange";
        String routingKey = "my_routing_key";
        String message = "Hello, world!";

        channel.basicPublish(exchangeName, routingKey, null, message.getBytes());

        // Consumer
        ConnectionFactory consumerFactory = new ConnectionFactory();
        Connection consumerConnection = consumerFactory.newConnection("amqp://localhost");
        Channel consumerChannel = consumerConnection.createChannel();

        String queueName = "my_queue";

        consumerChannel.queueDeclare(queueName, true, false, false, null);
        consumerChannel.queueBind(queueName, exchangeName, routingKey);

        QueueingConsumer consumer = new QueueingConsumer(consumerChannel);
        consumerChannel.basicConsume(queueName, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String receivedMessage = new String(delivery.getBody());
            System.out.println("Received message: " + receivedMessage);
        }
    }
}