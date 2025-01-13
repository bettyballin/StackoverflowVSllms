/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_448 {
    public static void main(String[] stringArray) throws IOException {
        String string;
        String string2 = "your_process_id_here";
        String string3 = "taskkill /PID " + string2 + " /F";
        Process process = Runtime.getRuntime().exec(string3);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
    }
}
