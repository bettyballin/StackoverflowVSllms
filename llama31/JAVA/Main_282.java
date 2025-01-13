import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class Main_282 {
    public static void main(String[] args) throws Exception {
        // Assume 'customerData' is your ArrayList of customer data
        ArrayList<String> customerData = new ArrayList<>();
        customerData.add("Customer1");
        customerData.add("Customer2");

        // Generate a secret key for encryption and signing
        SecretKeySpec secretKey = new SecretKeySpec(generateRandomKey(32), "AES");

        // Serialize and encrypt the data
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(serialize(customerData));

        // Sign the encrypted data
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        byte[] signature = mac.doFinal(encryptedData);

        // Transmit the encrypted data and signature

        // Verify the signature and decrypt the data on the receiving end
        if (verifySignature(encryptedData, signature, secretKey)) {
            byte[] decryptedData = decrypt(encryptedData, secretKey);
            ArrayList<String> deserializedData = deserialize(decryptedData);
            System.out.println(deserializedData);
        }
    }

    public static byte[] generateRandomKey(int size) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[size];
        secureRandom.nextBytes(key);
        return key;
    }

    public static byte[] serialize(ArrayList<String> data) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(data);
        oos.flush();
        return bos.toByteArray();
    }

    public static ArrayList<String> deserialize(byte[] data) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (ArrayList<String>) ois.readObject();
    }

    public static boolean verifySignature(byte[] data, byte[] signature, SecretKeySpec secretKey) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        byte[] expectedSignature = mac.doFinal(data);
        return java.util.Arrays.equals(signature, expectedSignature);
    }

    public static byte[] decrypt(byte[] encryptedData, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedData);
    }
}