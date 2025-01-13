/*
 * Decompiled with CFR 0.152.
 */
public class ParentProcess {
    public static void main(String[] stringArray) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("your_child_process_command");
        Process process = processBuilder.start();
        ProcessHandle processHandle = ProcessHandle.of(process.pid()).orElseThrow();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> processHandle.destroy()));
    }
}
