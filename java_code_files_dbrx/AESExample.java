import java.lang.String;
import javax.crypto.*;
import javax.crypto.spec.*;

public class AESExample {
    public static void main(String[] args) throws Exception {
        String key = "0123456789abcdef"; // 128 bit key (16 chars)
        byte[] ivBytes = new byte[16];

        Cipher cipher;
        SecretKeySpec secretKeySpec;
        IvParameterSpec ivParameterSpec;

        secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        ivParameterSpec = new IvParameterSpec(ivBytes);

        // If you want to use padding, you need to specify a cipher mode which does not automatically pad the data (like ECB)
        cipher = Cipher.getInstance("AES/ECB/NoPadding");
    }
}