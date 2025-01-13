/*
 * Decompiled with CFR 0.152.
 */
import java.security.cert.X509Certificate;

public class CertificateVerifier {
    public static void main(String[] stringArray) {
        Request request = new Request();
        X509Certificate[] x509CertificateArray = request.getCertificateChain();
        if (x509CertificateArray != null && x509CertificateArray.length > 0) {
            CertificateVerifier.verifyCertificate(x509CertificateArray);
            CertificateVerifier.accessSmartcardReader();
        } else {
            CertificateVerifier.blockAccess();
        }
    }

    private static void verifyCertificate(X509Certificate[] x509CertificateArray) {
        System.out.println("Certificate verification logic goes here.");
    }

    private static void accessSmartcardReader() {
        System.out.println("Smartcard reader access logic goes here.");
    }

    private static void blockAccess() {
        System.out.println("Access blocking logic goes here.");
    }

    public static class Request {
        public X509Certificate[] getCertificateChain() {
            return new X509Certificate[0];
        }
    }
}
