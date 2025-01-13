/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class RunAsUser {
    public static void main(String[] stringArray) {
        String string = "jim";
        String string2 = "jim's password";
        String string3 = "ls ~bob";
        ProcessBuilder processBuilder = new ProcessBuilder("su", "-c", string3, string);
        processBuilder.redirectErrorStream(true);
        try {
            String string4;
            Process process = processBuilder.start();
            OutputStream outputStream = process.getOutputStream();
            outputStream.write((string2 + "\n").getBytes());
            outputStream.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((string4 = bufferedReader.readLine()) != null) {
                System.out.println(string4);
            }
            process.waitFor();
        }
        catch (IOException iOException) {
            System.err.println("Error executing command: " + iOException.getMessage());
        }
        catch (InterruptedException interruptedException) {
            System.err.println("Error waiting for process to finish: " + interruptedException.getMessage());
        }
    }
}
