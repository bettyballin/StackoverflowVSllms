public class AgentEnumConverter {
    public static void main(String[] args) {
        // Declare variables
        Object retrievedEnumValue = null;
        java.util.Map<String, Object> agentMapping = new java.util.HashMap<>();
        String agentFromDb = null;

        // Convert from String to enum
        if(retrievedEnumValue != null){
            if(!agentMapping.containsKey(agentFromDb)) {
                throw new RuntimeException("Invalid agent found in the data");
            } else {
               // Do your save operation here using retrievedEnumValue or its ordinal value
               System.out.println(retrievedEnumValue);  // just an example of print statement
            }
        } else {
           System.out.println("Unknown Agent type.");
        }
    }
}