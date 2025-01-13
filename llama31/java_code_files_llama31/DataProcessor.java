/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DataProcessor {
    public static void main(String[] stringArray) throws Exception {
        byte[] byArray = "Hello, world!".getBytes();
        byte[] byArray2 = DataProcessor.compress(byArray, "gzip");
        byte[] byArray3 = DataProcessor.encrypt(byArray2, "AES");
        DataProcessor.send_data(byArray3);
    }

    public static byte[] compress(byte[] byArray, String string) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(byArray);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] encrypt(byte[] byArray, String string) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec("mysecretkey1234".getBytes(), string);
        Cipher cipher = Cipher.getInstance(string);
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(byArray);
    }

    public static void send_data(byte[] byArray) {
        System.out.println("Sending data...");
        for (byte by : byArray) {
            System.out.print(by + " ");
        }
        System.out.println();
    }
}
