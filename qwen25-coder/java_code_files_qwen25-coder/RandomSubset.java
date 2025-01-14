import java.util.*;
import java.security.SecureRandom;

public class RandomSubset {
    public static <T> List<T> getRandomSubset(Collection<T> items, int subsetSize) {
        if (subsetSize > items.size())
            throw new IllegalArgumentException("Subset size cannot be greater than the number of items.");

        List<T> list = new ArrayList<>(items);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < subsetSize; i++) {
            int indexToSwap = i + random.nextInt(list.size() - i);
            Collections.swap(list, i, indexToSwap);
        }
        return list.subList(0, subsetSize);
    }

    public static void main(String[] args) {
        Vector<String> itemsVector = new Vector<>(Arrays.asList(
            "item1", "item2", "item3", "item4", "item5",
            "item6", "item7", "item8", "item9", "item10"
        ));
        List<String> randomSubset = getRandomSubset(itemsVector, 5);
        System.out.println(randomSubset);
    }
}