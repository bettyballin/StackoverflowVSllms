/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class JavaProcessLauncher {
    public static void main(String[] stringArray) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-Xmx1024m", "-cp", "/path/to/your/classpath", "YourClassName");
        processBuilder.start();
    }
}
