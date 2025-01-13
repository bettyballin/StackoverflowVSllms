import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

public class AesDecryptor_1_1 {
    public static void main(String[] args) throws Exception {
        // Assuming 'provider' is a custom provider, use the default one for simplicity
        Provider provider = Security.getProvider("SunJCE");

        // Create a Cipher instance
        Cipher decrypt = Cipher.getInstance("AES/CBC/PKCS5Padding", provider);

        // Initialize the key and iv variables
        byte[] keyBytes = "your_key_here".getBytes();
        byte[] ivBytes = "your_iv_here".getBytes();
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        // Initialize the Cipher
        decrypt.init(Cipher.DECRYPT_MODE, key, iv);

        // Assuming 'encrypted' is the encrypted byte array
        byte[] encrypted = "your_encrypted_data_here".getBytes();
        byte[] decrypted = decrypt.doFinal(encrypted);

        // Print the decrypted data
        System.out.println(new String(decrypted));
    }
}