/*
 * Decompiled with CFR 0.152.
 */
public class AgentEnum {
    public static void main(String[] stringArray) {
    }

    public static enum Agent {
        GOOGLE('G'),
        YAHOO('Y'),
        MSN('M');

        private final char dbValue;

        private Agent(char c) {
            this.dbValue = c;
        }

        public char getDbValue() {
            return this.dbValue;
        }

        public static Agent getAgentFromDbValue(char c) {
            for (Agent agent : Agent.values()) {
                if (agent.getDbValue() != c) continue;
                return agent;
            }
            throw new IllegalArgumentException("No Agent found for dbValue: " + c);
        }
    }
}
