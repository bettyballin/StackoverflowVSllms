/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class WarFileEncryptor {
    public static void main(String[] stringArray) throws Exception {
        String string = "your_secret_key_here";
        SecretKeySpec secretKeySpec = new SecretKeySpec(string.getBytes(), "AES");
        File file = new File("path/to/your/warfile.war");
        File file2 = new File("path/to/encrypted/warfile.war");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        try (FileInputStream fileInputStream = new FileInputStream(file);
             FileOutputStream fileOutputStream = new FileOutputStream(file2);){
            int n;
            byte[] byArray = new byte[1024];
            while ((n = fileInputStream.read(byArray)) != -1) {
                fileOutputStream.write(cipher.update(byArray, 0, n));
            }
            fileOutputStream.write(cipher.doFinal());
        }
    }
}
