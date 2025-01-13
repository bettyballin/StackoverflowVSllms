/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class Main_432 {
    public static void main(String[] stringArray) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("path/to/your/exe", "arg1", "arg2");
            Process process = processBuilder.start();
        }
        catch (IOException iOException) {
            System.err.println("Error starting process: " + iOException.getMessage());
        }
    }
}
