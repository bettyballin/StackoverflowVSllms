import java.util.Properties;
import org.apache.kafka.clients.producer.*;

public class KafkaProducerExample {
    // Example of a simple Kafka producer
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>("my_topic", "key", "value"));
        producer.close();
    }
}