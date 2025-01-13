import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;

public class AesEncryptor_1_1 {
    public static void main(String[] args) throws Exception {
        // Assuming you have a provider, key and initialization vector (iv)
        Provider provider = java.security.Security.getProviders()[0];
        SecretKeySpec key = new SecretKeySpec("yourKeyBytes".getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec("yourIVBytes".getBytes());

        Cipher encrypt = Cipher.getInstance("AES/CBC/PKCS5Padding", provider);
        encrypt.init(Cipher.ENCRYPT_MODE, key, iv);
        String plainTxt = "Your Plain Text";
        byte[] encrypted = encrypt.doFinal(plainTxt.getBytes());
        System.out.println(new String(encrypted));
    }
}