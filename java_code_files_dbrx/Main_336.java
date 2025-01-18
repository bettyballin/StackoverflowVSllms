import java.util.*;
import java.util.stream.Collectors;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class Main {
    public static void main(String[] args) {
        //...rest of your code....

        BidiMap<String, Double> themap = new DualHashBidiMap<>();

        List<Double> list = new ArrayList<>(themap.values());
        /* Or even better to use Java 8 Stream API */
        List<Double> sortedListOfDoubles = themap.values().stream()
                .sorted((o1, o2) -> Double.compare(o1, o2))
                .collect(Collectors.toList());
    }
}