/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_212 {
    public static void main(String[] stringArray) throws IOException {
        String string;
        String[] stringArray2 = new String[]{"keytool", "-genkeypair", "-alias", "mycert", "-keyalg", "RSA", "-keysize", "2048", "-validity", "365", "-keystore", "mykeystore.jks", "-ext", "SAN=IP:192.168.56.1"};
        Process process = Runtime.getRuntime().exec(stringArray2);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
    }
}
