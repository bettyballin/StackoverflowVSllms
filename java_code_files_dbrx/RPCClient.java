import java.lang.String;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.AMQP;
import java.util.UUID;

public class RPCClient {
    private static final String TASK_QUEUE_NAME = "task_queue";

    public RPCClient() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            String replyQueueName = channel.queueDeclare().getQueue();

            AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .correlationId(UUID.randomUUID().toString())
                .replyTo(replyQueueName)
                .build();

            String message = "Hello RabbitMQ!";
            channel.basicPublish("", TASK_QUEUE_NAME, props, message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new RPCClient();
    }
}