// Sample code for AES encryption using Java Cipher API

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AesEncryptionExample {
    public static void main(String[] args) throws Exception {
        String plaintext = "SerializedObject"; // replace with your serialized object string

        KeyGenerator keyGen = KeyGenerator.getInstance("AES"); // Create an instance of AES cipher algorithm
        keyGen.init(128); // set the key size, in this case, 128 bits (AES supports various sizes like 192 and 256)
        SecretKey secretKey = keyGen.generateKey(); // Generate a secret encryption/decryption key using AES algorithm

        Cipher cipher = Cipher.getInstance("AES"); // Create an instance of AES cipher class to proceed with encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKey); // Set mode and provide key for initialization
        byte[] encryptedData = cipher.doFinal(plaintext.getBytes()); // Perform AES encryption on input data

        // Optionally, print the encrypted data in hexadecimal format
        System.out.print("Encrypted Data: ");
        for (byte b : encryptedData) {
            System.out.printf("%02X", b);
        }
        System.out.println();
    }
}