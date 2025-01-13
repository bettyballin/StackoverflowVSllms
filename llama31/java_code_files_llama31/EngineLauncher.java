/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class EngineLauncher {
    public static void main(String[] stringArray) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("engine.exe");
        processBuilder.environment().put("USERNAME", "your_username");
        processBuilder.environment().put("PASSWORD", "your_password");
        Process process = processBuilder.start();
    }
}
