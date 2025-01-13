/*
 * Decompiled with CFR 0.152.
 */
public static enum AgentEnum.Agent {
    GOOGLE('G'),
    YAHOO('Y'),
    MSN('M');

    private final char dbValue;

    private AgentEnum.Agent(char c) {
        this.dbValue = c;
    }

    public char getDbValue() {
        return this.dbValue;
    }

    public static AgentEnum.Agent getAgentFromDbValue(char c) {
        for (AgentEnum.Agent agent : AgentEnum.Agent.values()) {
            if (agent.getDbValue() != c) continue;
            return agent;
        }
        throw new IllegalArgumentException("No Agent found for dbValue: " + c);
    }
}
