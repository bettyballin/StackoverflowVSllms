/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class VbProgramRunner {
    public static void main(String[] stringArray) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("path/to/your/vb/program.exe");
            Process process = processBuilder.start();
        }
        catch (IOException iOException) {
            System.err.println("Error executing VB program: " + iOException.getMessage());
        }
    }
}
