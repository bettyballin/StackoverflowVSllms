import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class SecureSerializer {

    private static final int GCM_TAG_LENGTH = 128; // in bits
    private static final int GCM_IV_LENGTH = 96;   // in bits

    public static String encryptData(ArrayList<?> data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = new byte[GCM_IV_LENGTH / 8];
        new SecureRandom().nextBytes(iv); // Generate random IV
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
        
        // Serialize object to bytes
        byte[] dataBytes = serialize(data);

        byte[] ciphertext = cipher.doFinal(dataBytes);
        return Base64.getEncoder().encodeToString(ciphertext) + ":" + Base64.getEncoder().encodeToString(iv);
    }

    public static ArrayList<?> decryptData(String encrypted, SecretKey key) throws Exception {
        String[] parts = encrypted.split(":");
        byte[] ciphertext = Base64.getDecoder().decode(parts[0]);
        byte[] iv = Base64.getDecoder().decode(parts[1]);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);

        byte[] dataBytes = cipher.doFinal(ciphertext);
        return (ArrayList<?>) deserialize(dataBytes);
    }

    private static byte[] serialize(ArrayList<?> object) throws Exception {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(object);
            return bos.toByteArray();
        }
    }

    private static Object deserialize(byte[] data) throws Exception {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> customerData = new ArrayList<>();
        customerData.add("Sensitive Customer Data");

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        String encryptedData = encryptData(customerData, secretKey);
        System.out.println("Encrypted: " + encryptedData);

        ArrayList<?> decryptedData = decryptData(encryptedData, secretKey);
        System.out.println("Decrypted: " + decryptedData);
    }
}