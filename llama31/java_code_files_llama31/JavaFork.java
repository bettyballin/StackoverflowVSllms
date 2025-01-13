/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class JavaFork {
    public static void main(String[] stringArray) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), "IndependentProcess");
        Process process = processBuilder.start();
    }
}
