/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecCmd {
    public static void main(String[] stringArray) {
        try {
            String string = "dir";
            Process process = Runtime.getRuntime().exec(string);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String string2 = null;
            while ((string2 = bufferedReader.readLine()) != null) {
                System.out.println(string2);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
