import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class ImageEncryptor_1 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void main(String[] args) throws Exception {
        String key = "1Hbfh667adfDEJ78"; // 128 bit key
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);

        File inputFile = new File("input.jpg");
        File encryptedFile = new File("encrypted.jpg");

        encrypt(inputFile, encryptedFile, secretKey);
        File decryptedFile = new File("decrypted.jpg");

        decrypt(encryptedFile, decryptedFile, secretKey);
    }

    public static void encrypt(File inputFile, File outputFile, SecretKeySpec key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);

        int bytesRead;
        while ((bytesRead = byteArrayInputStream.read()) != -1) {
            cipherOutputStream.write(bytesRead);
        }
        cipherOutputStream.flush();
        cipherOutputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        fileOutputStream.write(Base64.getEncoder().encode(byteArrayOutputStream.toByteArray()));

        // Close streams
        fileOutputStream.close();
        inputStream.close();
        byteArrayInputStream.close();
        byteArrayOutputStream.close();
    }

    public static void decrypt(File inputFile, File outputFile, SecretKeySpec key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);

        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = Base64.getDecoder().decode(new String(inputStream.readAllBytes()));

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherInputStream cipherInputStream = new CipherInputStream(byteArrayInputStream, cipher);

        int bytesRead;
        while ((bytesRead = cipherInputStream.read()) != -1) {
            byteArrayOutputStream.write(bytesRead);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());

        // Close streams
        inputStream.close();
        cipherInputStream.close();
        byteArrayInputStream.close();
        byteArrayOutputStream.close();
        fileOutputStream.close();
    }
}