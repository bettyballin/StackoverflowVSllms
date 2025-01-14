import java.io.*;
import java.security.Security;

import org.bouncycastle.bcpg.*;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.*;
import org.bouncycastle.openpgp.operator.jcajce.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class FileDecryptAndVerify {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        String encryptedFilePath = "example.gpg";
        String decryptedFilePath = "decrypted_example.txt";

        // Read recipient's public key
        PGPPublicKeyRingCollection pgpPubRingCollection = readPublicKey(new FileInputStream("recipient_pub_key.asc"));
        PGPPublicKey recipientPubKey = getFirstPublicKey(pgpPubRingCollection);

        // Read recipient's secret key
        PGPSecretKeyRingCollection pgpSecRingCollection = readSecretKey(new FileInputStream("recipient_sec_key.asc"));
        PGPPrivateKey recipientPrivKey = findPrivateKey(pgpSecRingCollection, "YourPassphrase".toCharArray());

        // Decrypt the file
        InputStream in = PGPUtil.getDecoderStream(new FileInputStream(encryptedFilePath));
        PGPObjectFactory pgpObjFactory = new PGPObjectFactory(in, new JcaKeyFingerprintCalculator());

        Object nextObj = pgpObjFactory.nextObject();
        PGPEncryptedDataList encDataList;
        if (nextObj instanceof PGPEncryptedDataList) {
            encDataList = (PGPEncryptedDataList) nextObj;
        } else {
            encDataList = (PGPEncryptedDataList) pgpObjFactory.nextObject();
        }

        PGPPublicKeyEncryptedData pbe = null;
        for (PGPEncryptedData encryptedData : encDataList) {
            if (encryptedData instanceof PGPPublicKeyEncryptedData) {
                pbe = (PGPPublicKeyEncryptedData) encryptedData;
                break;
            }
        }

        if (pbe == null) {
            throw new IllegalArgumentException("No public key encrypted data found");
        }

        PGPPrivateKey sKey = findSecretKey(pgpSecRingCollection, pbe.getKeyID(), "YourPassphrase".toCharArray());
        if (sKey == null) {
            throw new IllegalArgumentException("Secret key for message not found.");
        }

        PublicKeyDataDecryptorFactory dataDecryptorFactory = new JcePublicKeyDataDecryptorFactoryBuilder()
                .setProvider("BC").build(sKey);

        InputStream clear = pbe.getDataStream(dataDecryptorFactory);
        PGPObjectFactory plainFact = new PGPObjectFactory(clear, new JcaKeyFingerprintCalculator());

        Object message = plainFact.nextObject();

        PGPOnePassSignatureList onePassSignatureList = null;
        PGPLiteralData literalData = null;
        PGPSignatureList signatureList = null;

        while (message != null) {
            if (message instanceof PGPOnePassSignatureList) {
                onePassSignatureList = (PGPOnePassSignatureList) message;
            } else if (message instanceof PGPLiteralData) {
                literalData = (PGPLiteralData) message;
            } else if (message instanceof PGPSignatureList) {
                signatureList = (PGPSignatureList) message;
            } else {
                throw new PGPException("Message not simple encrypted file.");
            }
            message = plainFact.nextObject();
        }

        if (onePassSignatureList == null || literalData == null || signatureList == null) {
            throw new PGPException("Incomplete PGP message.");
        }

        // Verification
        PGPOnePassSignature ops = onePassSignatureList.get(0);
        // Read signer's public key
        PGPPublicKeyRingCollection signerPubKeyRing = readPublicKey(new FileInputStream("signer_pub_key.asc"));
        PGPPublicKey signerPubKey = signerPubKeyRing.getPublicKey(ops.getKeyID());

        ops.init(new JcaPGPContentVerifierBuilderProvider().setProvider("BC"), signerPubKey);

        InputStream literalDataIn = literalData.getInputStream();
        OutputStream out = new BufferedOutputStream(new FileOutputStream(decryptedFilePath));

        int ch;
        while ((ch = literalDataIn.read()) >= 0) {
            ops.update((byte) ch);
            out.write(ch);
        }

        out.close();

        PGPSignature signature = signatureList.get(0);

        if (ops.verify(signature)) {
            System.out.println("File decrypted and signature verified successfully.");
        } else {
            System.err.println("Signature verification failed.");
        }
    }

    private static PGPPublicKeyRingCollection readPublicKey(InputStream input) throws IOException, PGPException {
        return new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(input), new JcaKeyFingerprintCalculator());
    }

    private static PGPSecretKeyRingCollection readSecretKey(InputStream input) throws IOException, PGPException {
        return new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(input), new JcaKeyFingerprintCalculator());
    }

    private static PGPPublicKey getFirstPublicKey(PGPPublicKeyRingCollection keyRingCollection) {
        for (PGPPublicKeyRing keyRing : keyRingCollection) {
            for (PGPPublicKey key : keyRing) {
                if (key.isEncryptionKey()) {
                    return key;
                }
            }
        }
        return null;
    }

    private static PGPPrivateKey findPrivateKey(PGPSecretKeyRingCollection pgpSec, char[] pass) throws PGPException {
        for (PGPSecretKeyRing keyRing : pgpSec) {
            for (PGPSecretKey key : keyRing) {
                PGPPrivateKey privateKey = findSecretKey(pgpSec, key.getKeyID(), pass);
                if (privateKey != null) {
                    return privateKey;
                }
            }
        }
        return null;
    }

    private static PGPPrivateKey findSecretKey(PGPSecretKeyRingCollection pgpSec, long keyID, char[] pass) throws PGPException {
        PGPSecretKey pgpSecKey = pgpSec.getSecretKey(keyID);

        if (pgpSecKey == null) {
            return null;
        }

        PBESecretKeyDecryptor decryptorFactory = new JcePBESecretKeyDecryptorBuilder()
                .setProvider("BC").build(pass);

        return pgpSecKey.extractPrivateKey(decryptorFactory);
    }
}