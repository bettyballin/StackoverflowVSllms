import java.lang.String;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Decrypter {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        File iFile = new File("normal.xml");
        FileInputStream fis = new FileInputStream(iFile);

        File oFile = new File("normal.xml.encrypted");
        FileOutputStream fos = new FileOutputStream(oFile);

        String algorithm = "DESede";
        byte[] keyBytes = new byte[] { 0x34, 0x11, 0x12, 0x06, 0x34, 0x11, 0x12, 0x06, 0x34, 0x11, 0x12, 0x06, 0x34,
                0x11, 0x12, 0x06, 0x34, 0x11, 0x12, 0x06, 0x34, 0x11, 0x12, 0x06 };

        SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        CipherOutputStream cos = new CipherOutputStream(fos, cipher);

        int b;
        while ((b = fis.read()) != -1) {
            cos.write(b);
        }

        cos.close(); // Close the CipherOutputStream
        fis.close();

        System.out.println("done");

        File ieFile = new File("normal.xml.encrypted");
        FileInputStream fies = new FileInputStream(ieFile);

        Cipher ieCipher = Cipher.getInstance(algorithm);
        ieCipher.init(Cipher.DECRYPT_MODE, key);
        CipherInputStream cis = new CipherInputStream(fies, ieCipher);

        File oeFile = new File("normal.xml.encrypted.xml");
        FileOutputStream foes = new FileOutputStream(oeFile);

        int c;
        while ((c = cis.read()) != -1) {
            foes.write(c);
        }

        cis.close(); // Close the CipherInputStream
        foes.close();

        System.out.println("done done");
    }
}