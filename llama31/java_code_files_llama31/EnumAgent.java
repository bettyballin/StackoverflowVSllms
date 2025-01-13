/*
 * Decompiled with CFR 0.152.
 */
public class EnumAgent {
    public static void main(String[] stringArray) {
        Agent agent = Agent.GOOGLE;
        char c = agent.getDbValue();
        Agent agent2 = Agent.getAgentFromDbValue('G');
    }
}
