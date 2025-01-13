/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_449 {
    public static void main(String[] stringArray) throws IOException {
        String string;
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "netstat -aon | find \"8080\"");
        Process process = processBuilder.start();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
    }
}
