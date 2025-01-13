import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.bouncycastle.asn1.ocsp.OCSPReq;
import org.bouncycastle.asn1.ocsp.OCSPResp;
import org.bouncycastle.cert.ocsp.OCSPReqBuilder;
import org.bouncycastle.cert.ocsp.OCSPRespBuilder;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.bc.BcDigestCalculatorProvider;

public class OCSPTest {
    public static void main(String[] args) throws Exception {
        String caCertFile = "ca_cert.pem";
        String clientCertFile = "client_cert.pem";
        String ocspUrl = "http://ocsp.example.com";

        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate caCert = (X509Certificate) cf.generateCertificate(new FileInputStream(caCertFile));
        X509Certificate clientCert = (X509Certificate) cf.generateCertificate(new FileInputStream(clientCertFile));

        OCSPReqBuilder reqBuilder = new OCSPReqBuilder();
        reqBuilder.addRequest(clientCert, caCert);
        OCSPReq req = reqBuilder.build();

        // Send the request and get the response
        URL url = new URL(ocspUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/ocsp-request");
        connection.setDoOutput(true);

        try (OutputStream out = connection.getOutputStream()) {
            out.write(req.getEncoded());
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            OCSPResp resp = new OCSPResp(connection.getInputStream());

            // Verify the response
            OCSPRespBuilder respBuilder = new OCSPRespBuilder();
            respBuilder.build(resp, new BcDigestCalculatorProvider(), new DefaultDigestAlgorithmIdentifierFinder());
        } else {
            System.out.println("Error: " + responseCode);
        }
    }
}