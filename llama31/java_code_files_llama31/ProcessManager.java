/*
 * Decompiled with CFR 0.152.
 */
public class ProcessManager {
    public static void main(String[] stringArray) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("your_child_process_command");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        long l = process.pid();
        Runtime.getRuntime().exec("your_kill_command " + l);
    }
}
