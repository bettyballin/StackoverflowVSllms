import java.util.HashMap;
import java.util.Map;

public class AgentMapper {
    // Create a hashmap with the reverse mapping as well
    Map<String, Agent> agentMapping = new HashMap<>();

    // Instance initializer block
    {
        for (Agent ag : Agent.values()) {
            // Forward direction (enum -> String)
            agentMapping.putIfAbsent(ag.name(), ag);
            // Reverse direction (String -> enum)
            if (!agentMapping.containsKey(ag.getName())) {
                agentMapping.put(ag.getName(), ag);
            }
        }
    }

    public static void main(String[] args) {
        // You can test the agentMapping here if needed
    }
}

// Define Agent enum
enum Agent {
    AGENT_A("Agent A"),
    AGENT_B("Agent B"),
    AGENT_C("Agent C");

    private String name;

    private Agent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}