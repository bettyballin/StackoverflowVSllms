/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Main_183 {
    public static void main(String[] stringArray) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("keystore.jks"), "keystorepassword".toCharArray());
        }
        catch (KeyStoreException keyStoreException) {
            System.err.println("Error getting KeyStore instance: " + keyStoreException.getMessage());
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error finding keystore file: " + fileNotFoundException.getMessage());
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.err.println("Error loading keystore: " + noSuchAlgorithmException.getMessage());
        }
        catch (CertificateException certificateException) {
            System.err.println("Error loading keystore: " + certificateException.getMessage());
        }
        catch (IOException iOException) {
            System.err.println("Error loading keystore: " + iOException.getMessage());
        }
    }
}
