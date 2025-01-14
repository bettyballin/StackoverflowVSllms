import java.lang.String;
public class Main_47 {
    public static void main(String[] args) {
        // Convert enum to DB value
        String dbValue = Agent.GOOGLE.getDbValue();  // This will return "G"

        // Convert DB value back to enum
        Agent agent = Agent.fromDbValue("Y");  // This will return the YAHOO enum

        System.out.println(dbValue);
        System.out.println(agent.name());
    }
}

enum Agent {
    GOOGLE("G"),
    YAHOO("Y");

    private String dbValue;

    private Agent(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static Agent fromDbValue(String dbValue) {
        for(Agent agent : Agent.values()) {
            if(agent.dbValue.equals(dbValue)) {
                return agent;
            }
        }
        return null;  // Or throw an exception if desired
    }
}