import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class RandomElementPicker {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("Apple", "Banana", "Cherry", "Date"));
        
        String randomElement = getRandomElement(set);
        System.out.println("Randomly selected element: " + randomElement);
    }

    public static <E> E getRandomElement(Set<E> set) {
        if (set.isEmpty()) {
            return null; // or throw an exception, based on your requirements
        }
        
        List<E> list = new ArrayList<>(set);
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}