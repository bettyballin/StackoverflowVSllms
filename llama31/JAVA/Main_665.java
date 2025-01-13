import org.bouncycastle.openpgp.PGPCompressedData;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.security.SecureRandom;

public class Main_665 {
    public static void main(String[] args) throws PGPException, IOException {
        // Load public key
        PGPPublicKey publicKey = null; // load public key from file or database;

        // Load secret key
        PGPSecretKey secretKey = null; // load secret key from file or database;

        // Encrypt message
        String message = "Hello, World!";
        org.bouncycastle.openpgp.PGPEncryptedDataGenerator encryptedDataGenerator = new org.bouncycastle.openpgp.PGPEncryptedDataGenerator(new org.bouncycastle.openpgp.jcajce.JcaPGPDataEncryptorBuilder(org.bouncycastle.openpgp.PGPEncryptedData.CAST5).setWithIntegrityPacket(true).setSecureRandom(new SecureRandom()));
        encryptedDataGenerator.addMethod(publicKey);
        ByteArrayInputStream in = new ByteArrayInputStream(message.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        encryptedDataGenerator.open(out, new byte[1024]);
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            encryptedDataGenerator.write(buf, 0, len);
        }
        encryptedDataGenerator.close();

        // Decrypt message
        ByteArrayInputStream decryptedIn = new ByteArrayInputStream(out.toByteArray());
        org.bouncycastle.openpgp.PGPObjectFactory pgpFact = new org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory(decryptedIn);
        org.bouncycastle.openpgp.PGPEncryptedDataList encList = (org.bouncycastle.openpgp.PGPEncryptedDataList) pgpFact.nextObject();
        PGPEncryptedData encryptedData = (PGPEncryptedData) encList.getEncryptedDataObjects().next();
        org.bouncycastle.openpgp.PGPPrivateKey privateKey = secretKey.extractPrivateKey(new org.bouncycastle.openpgp.jcajce.JcaPGPDigestCalculatorProviderBuilder().build().get(org.bouncycastle.openpgp.PGPUtil.SHA1), "password".toCharArray());
        DataInputStream clear = new DataInputStream(encryptedData.getDataStream(privateKey, "password".toCharArray()));
        org.bouncycastle.openpgp.PGPObjectFactory pgpFact2 = new org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory(clear);
        PGPLiteralData literalData = (PGPLiteralData) pgpFact2.nextObject();
        String decryptedMessage = new String(literalData.getData());

        System.out.println(decryptedMessage); // prints "Hello, World!"
    }
}