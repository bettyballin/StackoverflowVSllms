import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.bouncycastle.cert.jcajce.JcaCertificateID;
import org.bouncycastle.cert.ocsp.*;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class OCSPChecker {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        FileInputStream is = new FileInputStream("issuer.crt");
        CertificateFactory cf = CertificateFactory.getInstance("X.509", "BC");
        X509Certificate issuerCert = (X509Certificate) cf.generateCertificate(is);
        is.close();

        is = new FileInputStream("certificate.crt");
        X509Certificate clientCert = (X509Certificate) cf.generateCertificate(is);
        is.close();

        DigestCalculatorProvider digCalcProv = new JcaDigestCalculatorProviderBuilder()
                .setProvider("BC").build();

        CertificateID id = new JcaCertificateID(
                digCalcProv.get(CertificateID.HASH_SHA1),
                issuerCert,
                clientCert.getSerialNumber());

        OCSPReqBuilder builder = new OCSPReqBuilder();
        builder.addRequest(id);

        OCSPReq request = builder.build();
        byte[] array = request.getEncoded();

        // The OCSP response should be fetched from an OCSP responder.
        // Since this code does not connect to a responder, we'll skip fetching the response.

        // Output a message indicating success
        System.out.println("OCSP Request generated successfully.");

        // Optionally, write the request to a file
        FileOutputStream fos = new FileOutputStream("ocsp_request.der");
        fos.write(array);
        fos.close();
    }
}