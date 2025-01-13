/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LocalUsers_1 {
    public static void main(String[] stringArray) throws IOException {
        String string;
        Process process = Runtime.getRuntime().exec("wmic useraccount get name");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
    }
}
