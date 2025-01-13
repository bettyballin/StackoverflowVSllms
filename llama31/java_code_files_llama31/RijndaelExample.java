/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.crypto.BlockCipher
 *  org.bouncycastle.crypto.BufferedBlockCipher
 *  org.bouncycastle.crypto.CipherParameters
 *  org.bouncycastle.crypto.engines.RijndaelEngine
 *  org.bouncycastle.crypto.io.CipherInputStream
 *  org.bouncycastle.crypto.io.CipherOutputStream
 *  org.bouncycastle.crypto.paddings.BlockCipherPadding
 *  org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher
 *  org.bouncycastle.crypto.paddings.ZeroBytePadding
 *  org.bouncycastle.crypto.params.KeyParameter
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.io.CipherInputStream;
import org.bouncycastle.crypto.io.CipherOutputStream;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.KeyParameter;

public class RijndaelExample {
    public static void main(String[] stringArray) throws Exception {
        byte[] byArray = new byte[32];
        byte[] byArray2 = "Hello, World!".getBytes();
        byte[] byArray3 = RijndaelExample.encrypt(byArray2, byArray);
        byte[] byArray4 = RijndaelExample.decrypt(byArray3, byArray);
        System.out.println("Decrypted: " + new String(byArray4));
    }

    public static byte[] encrypt(byte[] byArray, byte[] byArray2) throws Exception {
        RijndaelEngine rijndaelEngine = new RijndaelEngine(256);
        PaddedBufferedBlockCipher paddedBufferedBlockCipher = new PaddedBufferedBlockCipher((BlockCipher)rijndaelEngine, (BlockCipherPadding)new ZeroBytePadding());
        KeyParameter keyParameter = new KeyParameter(byArray2);
        paddedBufferedBlockCipher.init(true, (CipherParameters)keyParameter);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream((OutputStream)byteArrayOutputStream, (BufferedBlockCipher)paddedBufferedBlockCipher);
        cipherOutputStream.write(byArray);
        cipherOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] decrypt(byte[] byArray, byte[] byArray2) throws Exception {
        int n;
        RijndaelEngine rijndaelEngine = new RijndaelEngine(256);
        PaddedBufferedBlockCipher paddedBufferedBlockCipher = new PaddedBufferedBlockCipher((BlockCipher)rijndaelEngine, (BlockCipherPadding)new ZeroBytePadding());
        KeyParameter keyParameter = new KeyParameter(byArray2);
        paddedBufferedBlockCipher.init(false, (CipherParameters)keyParameter);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        CipherInputStream cipherInputStream = new CipherInputStream((InputStream)byteArrayInputStream, (BufferedBlockCipher)paddedBufferedBlockCipher);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray3 = new byte[1024];
        while ((n = cipherInputStream.read(byArray3)) != -1) {
            byteArrayOutputStream.write(byArray3, 0, n);
        }
        cipherInputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
