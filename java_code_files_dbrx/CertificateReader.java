import java.security.*;
import java.io.*;
import java.nio.file.Files;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class CertificateReader {
    public static void main(String[] args) throws Exception {
        // Read your X.509 Certificate as bytes from, e.g., DER format file (cerFile).
        byte[] certBytes = Files.readAllBytes(new File("cerFile").toPath());

        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        // Create X509 certificate objects and parse the certificate from bytes.
        X509Certificate cert = (X509Certificate)cf.generateCertificate(new ByteArrayInputStream(certBytes));
    }
}