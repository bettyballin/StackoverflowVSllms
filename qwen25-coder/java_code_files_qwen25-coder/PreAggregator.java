import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.ArrayList;

public class PreAggregator {
    // Example pseudo-code for pre-aggregation
    public static void main(String[] args) {
        Map<String, Double> preAggregatedSales = new HashMap<>();
        List<String> products = new ArrayList<>();
        Map<String, Map<String, Double>> cubeData = new HashMap<>();

        for (String product : products) {
            double totalSales = 0;
            for (Entry<String, Map<String, Double>> timeData : cubeData.entrySet()) {
                if (timeData.getValue().containsKey(product)) {
                    totalSales += timeData.getValue().get(product);
                }
            }
            preAggregatedSales.put(product, totalSales);
        }
    }
}