/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcessHarness {
    public static void main(String[] stringArray) throws Exception {
        String string;
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), MyRunnable.class.getName());
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        OutputStream outputStream = process.getOutputStream();
        InputStream inputStream = process.getInputStream();
        String string2 = "Hello, other process!";
        outputStream.write(string2.getBytes());
        outputStream.write(System.lineSeparator().getBytes());
        outputStream.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println("Received from process: " + string);
        }
        process.waitFor();
    }
}
