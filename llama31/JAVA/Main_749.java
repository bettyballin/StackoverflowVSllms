import java.util.*;

public class Main_749_749 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        // Convert set to list
        List<String> list = new ArrayList<>(set);

        // Use Random class to pick a random element
        Random rand = new Random();
        String randomElement = list.get(rand.nextInt(list.size()));

        System.out.println(randomElement);
    }
}