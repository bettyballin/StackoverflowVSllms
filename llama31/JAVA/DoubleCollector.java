import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DoubleCollector {
    Map<String, Double> themap = new HashMap<>();
    Collection<Double> coll = themap.values();
    List<Double> list = new ArrayList<>(coll);

    public static void main(String[] args) {
        new DoubleCollector();
    }
}