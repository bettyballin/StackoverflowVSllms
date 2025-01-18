import java.util.*;

public class RandomSetElement {
    public static <T> T getRandomObject(Set<T> set) {
        Object[] arr = set.toArray();
        return (T) arr[new Random().nextInt(set.size())];
    }
}