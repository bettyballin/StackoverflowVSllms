public class AgentTypeEnum {
    public enum Agent {
        GOOGLE("G"),
        YAHOO("Y"),
        MSN("M");

        private final String dbValue;

        Agent(String dbValue) {
            this.dbValue = dbValue;
        }

        public String getDbValue() {
            return dbValue;
        }

        // Method to map string back to enum
        public static Agent fromDbValue(String dbValue) {
            for (Agent agent : Agent.values()) {
                if (agent.getDbValue().equals(dbValue)) {
                    return agent;
                }
            }
            throw new IllegalArgumentException("Unknown database value: " + dbValue);
        }
    }

    public static void main(String[] args) {
    }
}