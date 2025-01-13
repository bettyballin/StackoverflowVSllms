import java.util.*;

public class Main_750_750 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        String randomElement = set.stream()
                .skip(new Random().nextInt(set.size()))
                .findFirst()
                .orElse(null);

        System.out.println(randomElement);
    }
}