import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateThumbprint {
    public static void main(String[] args) throws Exception {
        // Load the certificate from a file
        InputStream inStream = new FileInputStream("certificate.crt");
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
        inStream.close();

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hashBytes = md.digest(cert.getEncoded());

        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            String hexVal = Integer.toHexString(0xFF & b);
            if (hexVal.length() == 1) {
                sb.append('0');
            }
            sb.append(hexVal).append(" ");
        }
        System.out.println(sb.toString().trim()); // prints the thumbprint here.
    }
}