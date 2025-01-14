// WorkerTaskProducer.java
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class WorkerTaskProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        for (int i = 1; i <= 100; i += 10) {
            String recordBatch = String.format("%d to %d", i, i + 9);
            producer.send(new ProducerRecord<>("tasks-topic", Integer.toString(i), recordBatch));
        }

        producer.close();
    }
}