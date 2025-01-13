/*
 * Decompiled with CFR 0.152.
 */
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CredentialVerifier {
    public static boolean verifyCredentials(String string, String string2) throws NoSuchAlgorithmException, InvalidKeyException {
        String string3 = CredentialSigner.signCredentials(string);
        return MessageDigest.isEqual(string3.getBytes(), string2.getBytes());
    }

    public static void main(String[] stringArray) {
    }
}
