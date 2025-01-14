import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomShuffle {
    public static void main(String[] args) {
        // Create your list of quality results
        List<String> qualityResults = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            qualityResults.add("Good");
        }
        for (int i = 0; i < 5; i++) {
            qualityResults.add("Bad1");
        }
        for (int i = 0; i < 3; i++) {
            qualityResults.add("Bad2");
        }

        // Seed the random number generator for deterministic results
        Random random = new Random(42); // Use any seed value you prefer

        // Shuffle the list using Fisher-Yates algorithm
        Collections.shuffle(qualityResults, random);

        // Print shuffled list
        System.out.println("Shuffled List: " + qualityResults);
    }
}