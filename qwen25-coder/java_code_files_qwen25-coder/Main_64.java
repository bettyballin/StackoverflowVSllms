import java.util.LinkedHashMap;
import java.util.Map;

public class Main_64 {
    public static void main(String[] args) {
        Map<String, String> stateMap = new LinkedHashMap<>();
        stateMap.put("ALABAMA", "AL");
        stateMap.put("ALASKA", "AK");
        // continue with other states...
        stateMap.put("WYOMING", "WY");

        for (Map.Entry<String, String> entry : stateMap.entrySet()) {
            System.out.println("The abbreviation for " + entry.getKey() + " is " + entry.getValue());
        }
    }
}