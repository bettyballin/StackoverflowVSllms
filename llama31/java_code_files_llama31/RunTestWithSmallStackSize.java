/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class RunTestWithSmallStackSize {
    public static void main(String[] stringArray) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-Xss1024k", "YourTestClass");
        Process process = processBuilder.start();
    }
}
