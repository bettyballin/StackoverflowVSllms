import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class EnumMapper {

    public enum Agent {
        GOOGLE
        // ... other enum values
    }

    public static void main(String[] args) {
        // Convert from enum to String
        String agentFromDb = "google"; // example value coming from DB

        // Create a map of agent names to Agent enum values
        Map<String, Agent> agentMapping = new HashMap<>();
        agentMapping.put("google", Agent.GOOGLE);
        // ... add other mappings as needed

        if (agentMapping.containsKey(agentFromDb)) {
            Agent retrievedEnumValue = agentMapping.get(agentFromDb);
        } else {
            throw new RuntimeException("Invalid agent found in the data");
        }
    }
}