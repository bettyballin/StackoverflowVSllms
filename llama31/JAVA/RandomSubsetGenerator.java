import java.security.SecureRandom;
import java.util.List;
import java.util.ArrayList;

public class RandomSubsetGenerator {
    public static void main(String[] args) {
        List<String> itemsList = getItems();
        SecureRandom rand = new SecureRandom(); // use SecureRandom for better randomness
        List<String> subsetList = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(itemsList.size());
            subsetList.add(itemsList.remove(index));
        }
        System.out.println(subsetList);
    }

    public static List<String> getItems() {
        // Replace this with your actual method implementation
        List<String> items = new ArrayList<>();
        items.add("Item1");
        items.add("Item2");
        items.add("Item3");
        items.add("Item4");
        items.add("Item5");
        items.add("Item6");
        items.add("Item7");
        items.add("Item8");
        items.add("Item9");
        items.add("Item10");
        return items;
    }
}