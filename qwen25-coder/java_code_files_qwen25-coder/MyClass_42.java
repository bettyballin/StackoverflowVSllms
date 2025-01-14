import java.security.MessageDigest;
import java.security.cert.X509Certificate;

public class MyClass {

    public String getCertificateThumbprint(X509Certificate cert) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        byte[] der = cert.getEncoded();
        md.update(der);
        byte[] digest = md.digest();
        return bytesToHex(digest);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

}