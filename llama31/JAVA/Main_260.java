import java.util.HashMap;
import java.util.Map;

public class Main_260_260 {
    public static void main(String[] args) {
        int[] values = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int m = 4; // maximum value in the domain

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int value : values) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                System.out.println("Value " + entry.getKey() + " occurs most frequently, with frequency " + maxFrequency);
            }
        }
    }
}