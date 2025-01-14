import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class QueueBalancer {
    private final List<Queue<String>> queues;
    private final Random random;

    public QueueBalancer(List<Queue<String>> queues) {
        this.queues = queues;
        this.random = new Random();
    }

    // Method to get the next item from one of the queues
    public String getNextItem() {
        int queueCount = queues.size();
        if (queueCount == 0) return null;

        List<Integer> nonEmptyQueueIndices = new ArrayList<>();
        for (int i = 0; i < queueCount; i++) {
            if (!queues.get(i).isEmpty()) {
                nonEmptyQueueIndices.add(i);
            }
        }

        if (nonEmptyQueueIndices.isEmpty()) return null;

        // Randomly choose one of the non-empty queues
        int randomIndex = random.nextInt(nonEmptyQueueIndices.size());
        int queueIndex = nonEmptyQueueIndices.get(randomIndex);

        return queues.get(queueIndex).poll();
    }

    public static void main(String[] args) {
        Queue<String> queue1 = new LinkedList<>(Arrays.asList("set1_1.xml", "set1_2.xml", "set1_3.xml"));
        Queue<String> queue2 = new LinkedList<>(Arrays.asList("set2_1.xml", "set2_2.xml", "set2_3.xml"));
        Queue<String> queue3 = new LinkedList<>(Arrays.asList("set3_1.xml", "set3_2.xml", "set3_3.xml"));

        List<Queue<String>> queues = Arrays.asList(queue1, queue2, queue3);
        QueueBalancer balancer = new QueueBalancer(queues);

        while (true) {
            String item = balancer.getNextItem();
            if (item == null) break;
            System.out.println("Transmitting: " + item);
        }
    }
}