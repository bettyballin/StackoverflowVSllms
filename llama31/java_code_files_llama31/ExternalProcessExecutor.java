/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.OutputStream;

public class ExternalProcessExecutor {
    public static void main(String[] stringArray) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("path/to/your/exe");
        Process process = processBuilder.start();
        OutputStream outputStream = process.getOutputStream();
        outputStream.write("your_data".getBytes());
        outputStream.close();
    }
}
