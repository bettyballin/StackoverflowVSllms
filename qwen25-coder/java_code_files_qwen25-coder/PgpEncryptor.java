import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.jcajce.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.bcpg.*;
import java.io.*;
import java.security.Security;
import java.security.SecureRandom;
import java.util.Date;

public class PgpEncryptor {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public void encrypt(String inputFile, String outputFile, String publicKeyFile) throws IOException, PGPException {
        try (InputStream keyIn = new BufferedInputStream(new FileInputStream(publicKeyFile));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(outputFile));
             InputStream fis = new BufferedInputStream(new FileInputStream(inputFile))) {

            PGPPublicKey pubKey = readPublicKey(keyIn);

            PGPEncryptedDataGenerator encGen = new PGPEncryptedDataGenerator(
                    new JcePGPDataEncryptorBuilder(SymmetricKeyAlgorithmTags.AES_256)
                            .setWithIntegrityPacket(true)
                            .setSecureRandom(new SecureRandom())
                            .setProvider("BC")
            );

            encGen.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(pubKey).setProvider("BC"));

            try (OutputStream cOut = encGen.open(out, new byte[1 << 16])) {
                PGPCompressedDataGenerator comGen = new PGPCompressedDataGenerator(PGPCompressedData.ZLIB);

                OutputStream cos = comGen.open(cOut);
                PGPLiteralDataGenerator lData = new PGPLiteralDataGenerator();

                OutputStream pOut = lData.open(cos, PGPLiteralData.BINARY,
                        new File(inputFile).getName(), new Date(), new byte[1 << 16]);

                byte[] buf = new byte[1 << 16];
                int len;
                while ((len = fis.read(buf)) > 0) {
                    pOut.write(buf, 0, len);
                }

                pOut.close();
                lData.close();
                cos.close();
                comGen.close();
            }
        }
    }

    private static PGPPublicKey readPublicKey(InputStream input) throws IOException, PGPException {
        PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(
                PGPUtil.getDecoderStream(input), new JcaKeyFingerprintCalculator());

        for (PGPPublicKeyRing keyRing : pgpPub) {
            for (PGPPublicKey key : keyRing) {
                if (key.isEncryptionKey()) {
                    return key;
                }
            }
        }

        throw new IllegalArgumentException("Can't find encryption key in key ring.");
    }

    public static void main(String[] args) {
        try {
            PgpEncryptor encryptor = new PgpEncryptor();
            encryptor.encrypt("input.txt", "encrypted_output.pgp", "public_key.asc");
            System.out.println("Encryption successful!");
        } catch (IOException | PGPException e) {
            e.printStackTrace();
        }
    }
}