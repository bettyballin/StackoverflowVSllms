/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class Main_213 {
    public static void main(String[] stringArray) throws IOException, InterruptedException {
        String[] stringArray2 = new String[]{"keytool", "-genkeypair", "-alias", "mycert", "-keyalg", "RSA", "-keysize", "2048", "-validity", "365", "-keystore", "mykeystore.jks", "-dname", "CN=192.168.56.1, OU=My Org, O=My Company, L=My City, ST=My State, C=US"};
        Process process = Runtime.getRuntime().exec(stringArray2);
        process.waitFor();
    }
}
