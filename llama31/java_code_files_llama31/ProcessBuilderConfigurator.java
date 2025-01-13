/*
 * Decompiled with CFR 0.152.
 */
public class ProcessBuilderConfigurator {
    public static void main(String[] stringArray) {
        ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
        processBuilder.environment().put("CYGWIN", "ntsec");
    }
}
