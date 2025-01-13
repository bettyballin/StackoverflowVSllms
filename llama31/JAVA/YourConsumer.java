import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class YourConsumer {
    @RabbitListener(queues = "your.queue")
    public void yourMethod(String message) {
        // Your message processing logic here
    }

    public static void main(String[] args) {
        // To actually use YourConsumer, you would need a Spring Application context
        // For demonstration purposes, we're keeping this empty.
    }
}