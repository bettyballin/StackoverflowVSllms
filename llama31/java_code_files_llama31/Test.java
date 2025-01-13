/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] stringArray) throws Exception {
        String string;
        Process process = Runtime.getRuntime().exec("dir");
        process.waitFor();
        InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
        process.waitFor();
        System.out.println("exit: " + process.exitValue());
        process.destroy();
    }
}
