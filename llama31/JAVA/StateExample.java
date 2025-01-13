import java.util.HashMap;
import java.util.Map;

public class StateExample {
    public static void main(String[] args) {
        Map<String, String> stateMap = new HashMap<>();
        stateMap.put("ALABAMA", "AL");
        stateMap.put("ALASKA", "AK");
        stateMap.put("WYOMING", "WY");

        for (Map.Entry<String, String> entry : stateMap.entrySet()) {
            System.out.println("The abbreviation for " + entry.getKey() + " is " + entry.getValue());
        }
    }
}