import java.lang.String;

public class AgentEnum {
    public enum Agent {
        GOOGLE('G'),
        YAHOO('Y'),
        MSN('M');

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
            throw new IllegalArgumentException("No Agent found for dbValue: " + dbValue);
        }
    }

    public static void main(String[] args) {}
}