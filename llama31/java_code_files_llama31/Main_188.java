/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class Main_188 {
    public static void main(String[] stringArray) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("mysql_installation_command");
        Process process = processBuilder.start();
        long l = ProcessHandle.of(process.pid()).orElseThrow().pid();
        process.waitFor();
        Main_188.runDbScripts();
    }

    public static void runDbScripts() {
        System.out.println("Running DB scripts...");
    }
}
