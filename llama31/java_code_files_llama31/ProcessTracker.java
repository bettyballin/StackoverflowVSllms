/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessTracker {
    public static void main(String[] stringArray) {
        String string = System.getProperty("os.name");
        String string2 = "";
        if (string.contains("Windows")) {
            string2 = "tasklist";
        } else if (string.contains("Mac") || string.contains("Linux")) {
            string2 = "ps -ef";
        }
        try {
            String string3;
            Process process = Runtime.getRuntime().exec(string2);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((string3 = bufferedReader.readLine()) != null) {
                System.out.println(string3);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
