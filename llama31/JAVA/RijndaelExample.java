import java.lang.String;
import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.io.CipherInputStream;
import org.bouncycastle.crypto.io.CipherOutputStream;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.KeyParameter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class RijndaelExample {
    public static void main(String[] args) throws Exception {
        byte[] key = new byte[32]; // 256-bit key
        byte[] data = "Hello, World!".getBytes();

        // Encrypt
        byte[] encrypted = encrypt(data, key);

        // Decrypt
        byte[] decrypted = decrypt(encrypted, key);

        System.out.println("Decrypted: " + new String(decrypted));
    }

    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        RijndaelEngine engine = new RijndaelEngine(256);
        PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(engine, new ZeroBytePadding());
        KeyParameter keyParam = new KeyParameter(key);
        cipher.init(true, keyParam);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        OutputStream cout = new CipherOutputStream(bout, cipher);
        cout.write(data);
        cout.close();

        return bout.toByteArray();
    }

    public static byte[] decrypt(byte[] encrypted, byte[] key) throws Exception {
        RijndaelEngine engine = new RijndaelEngine(256);
        PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(engine, new ZeroBytePadding());
        KeyParameter keyParam = new KeyParameter(key);
        cipher.init(false, keyParam);

        ByteArrayInputStream bin = new ByteArrayInputStream(encrypted);
        InputStream cin = new CipherInputStream(bin, cipher);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int len;
        while ((len = cin.read(buffer)) != -1) {
            bout.write(buffer, 0, len);
        }
        cin.close();

        return bout.toByteArray();
    }
}