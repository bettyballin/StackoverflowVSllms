/*
 * Decompiled with CFR 0.152.
 */
enum Agent {
    GOOGLE('G'),
    AMAZON('A'),
    FACEBOOK('F');

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
        throw new IllegalArgumentException("Invalid dbValue");
    }
}
