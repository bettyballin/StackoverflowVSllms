/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Decrypter {
    public static void main(String[] stringArray) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        int n;
        int n2;
        File file = new File("normal.xml");
        FileInputStream fileInputStream = new FileInputStream(file);
        File file2 = new File("normal.xml.encrypted");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        String string = "DESede";
        byte[] byArray = new byte[]{52, 17, 18, 6, 52, 17, 18, 6, 52, 17, 18, 6, 52, 17, 18, 6, 52, 17, 18, 6, 52, 17, 18, 6};
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, string);
        Cipher cipher = Cipher.getInstance(string);
        cipher.init(1, secretKeySpec);
        CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
        while ((n2 = fileInputStream.read()) != -1) {
            cipherOutputStream.write(n2);
        }
        cipherOutputStream.close();
        fileInputStream.close();
        System.out.println("done");
        File file3 = new File("normal.xml.encrypted");
        FileInputStream fileInputStream2 = new FileInputStream(file3);
        Cipher cipher2 = Cipher.getInstance(string);
        cipher2.init(2, secretKeySpec);
        CipherInputStream cipherInputStream = new CipherInputStream(fileInputStream2, cipher2);
        File file4 = new File("normal.xml.encrypted.xml");
        FileOutputStream fileOutputStream2 = new FileOutputStream(file4);
        while ((n = cipherInputStream.read()) != -1) {
            fileOutputStream2.write(n);
        }
        cipherInputStream.close();
        fileOutputStream2.close();
        System.out.println("done done");
    }
}
