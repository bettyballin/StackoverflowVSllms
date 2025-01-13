import java.lang.String;

enum Agent {
    GOOGLE('G'),
    AMAZON('A'),
    FACEBOOK('F');

    private final char dbValue;

    Agent(char dbValue) {
        this.dbValue = dbValue;
    }

    public char getDbValue() {
        return dbValue;
    }

    public static Agent getAgentFromDbValue(char dbValue) {
        for (Agent agent : Agent.values()) {
            if (agent.getDbValue() == dbValue) {
                return agent;
            }
        }
        throw new IllegalArgumentException("Invalid dbValue");
    }
}

public class EnumAgent {
    public static void main(String[] args) {
        Agent agent = Agent.GOOGLE;
        char dbValue = agent.getDbValue(); // dbValue will be 'G'

        Agent agentFromDb = Agent.getAgentFromDbValue('G'); // agentFromDb will be Agent.GOOGLE
    }
}