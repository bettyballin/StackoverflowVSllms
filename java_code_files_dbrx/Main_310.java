import java.util.HashMap;
import java.util.Map;

public class Main_310 {
    public static void main(String[] args) {
        Map<String, String> stateMap = new HashMap<>();
        stateMap.put("ALABAMA", "AL");
        stateMap.put("ALASKA", "AK");
        // etc...
        stateMap.forEach((k, v) -> System.out.println("The abbreviation for " + k + " is " + v));
    }
}