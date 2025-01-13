import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DESX {
  public static byte[] encrypt(byte[] plaintext, byte[] key) throws Exception {
    // XOR plaintext with first 64-bit key
    byte[] xoredPlaintext = new byte[plaintext.length];
    for (int i = 0; i < plaintext.length; i++) {
      xoredPlaintext[i] = (byte) (plaintext[i] ^ key[i % 8]);
    }

    // Encrypt with DES
    Cipher des = Cipher.getInstance("DES");
    SecretKeySpec desKey = new SecretKeySpec(key, 8, 8);
    des.init(Cipher.ENCRYPT_MODE, desKey);
    byte[] ciphertext = des.doFinal(xoredPlaintext);

    // XOR ciphertext with second 64-bit key
    byte[] xoredCiphertext = new byte[ciphertext.length];
    for (int i = 0; i < ciphertext.length; i++) {
      xoredCiphertext[i] = (byte) (ciphertext[i] ^ key[i % 8 + 8]);
    }

    return xoredCiphertext;
  }

  public static byte[] decrypt(byte[] ciphertext, byte[] key) throws Exception {
    // XOR ciphertext with second 64-bit key
    byte[] xoredCiphertext = new byte[ciphertext.length];
    for (int i = 0; i < ciphertext.length; i++) {
      xoredCiphertext[i] = (byte) (ciphertext[i] ^ key[i % 8 + 8]);
    }

    // Decrypt with DES
    Cipher des = Cipher.getInstance("DES");
    SecretKeySpec desKey = new SecretKeySpec(key, 8, 8);
    des.init(Cipher.DECRYPT_MODE, desKey);
    byte[] plaintext = des.doFinal(xoredCiphertext);

    // XOR plaintext with first 64-bit key
    byte[] xoredPlaintext = new byte[plaintext.length];
    for (int i = 0; i < plaintext.length; i++) {
      xoredPlaintext[i] = (byte) (plaintext[i] ^ key[i % 8]);
    }

    return xoredPlaintext;
  }

  public static void main(String[] args) {
    try {
      byte[] key = "0123456789abcdef".getBytes();
      byte[] plaintext = "Hello, World!".getBytes();
      byte[] ciphertext = encrypt(plaintext, key);
      byte[] decrypted = decrypt(ciphertext, key);
      System.out.println("Plaintext: " + new String(plaintext));
      System.out.println("Ciphertext: " + new String(ciphertext));
      System.out.println("Decrypted: " + new String(decrypted));
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}