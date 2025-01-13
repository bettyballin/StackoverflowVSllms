import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class KeyValue {
    private Integer key;
    private Integer value;

    public KeyValue(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}

public class Main_233 {
    public static void main(String[] args) {
        // Input data: a list of integers
        List<Integer> input = Arrays.asList(5, 2, 8, 3, 1, 6, 4);

        // Map phase: extract key-value pairs (key = value to be sorted, value = original data)
        List<KeyValue> mapped = input.stream()
                .map(i -> new KeyValue(i, i))
                .collect(Collectors.toList());

        // Partitioning: partition the data across multiple Reducer nodes
        int numReducers = 2;
        List<List<KeyValue>> partitions = new ArrayList<>();
        for (int i = 0; i < numReducers; i++) {
            partitions.add(new ArrayList<>());
        }
        for (KeyValue kv : mapped) {
            int partitionId = kv.getKey() % numReducers;
            partitions.get(partitionId).add(kv);
        }

        // Shuffle and sort: each Reducer node sorts its partition
        List<KeyValue> sorted = new ArrayList<>();
        for (List<KeyValue> partition : partitions) {
            Collections.sort(partition, Comparator.comparing(KeyValue::getKey));
            sorted.addAll(partition);
        }

        // Reduce phase: output the final sorted data
        List<Integer> output = sorted.stream()
                .map(KeyValue::getValue)
                .collect(Collectors.toList());

        System.out.println(output); // [1, 2, 3, 4, 5, 6, 8]
    }
}