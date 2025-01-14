import java.lang.String;
import java.util.Arrays;

public class RecurringValuesFinder {
    public static int[] findMostRecurring(int[] set, int m) {
        // Initialize an array to store the frequency of each number from 1 to m
        int[] frequency = new int[m + 1];
        
        // Count the occurrences of each number in the set
        for (int number : set) {
            if (number >= 1 && number <= m) {
                frequency[number]++;
            }
        }
        
        // Find the maximum frequency and count how many numbers have this frequency
        int maxFrequency = Arrays.stream(frequency).max().orElse(0);
        int recurringCount = 0;
        for (int i = 1; i <= m; i++) {
            if (frequency[i] == maxFrequency) {
                recurringCount++;
            }
        }
        
        // Collect all numbers with the maximum frequency
        int[] result = new int[recurringCount];
        int index = 0;
        for (int i = 1; i <= m; i++) {
            if (frequency[i] == maxFrequency) {
                result[index++] = i;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] set = {1, 2, 2, 3, 4, 4, 4, 5, 5, 5};
        int m = 5;
        int[] mostRecurringValues = findMostRecurring(set, m);
        
        System.out.println("Most recurring values: " + Arrays.toString(mostRecurringValues));
    }
}