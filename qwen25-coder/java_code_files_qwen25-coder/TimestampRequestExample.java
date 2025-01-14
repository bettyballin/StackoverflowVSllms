import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.tsp.TimeStampResp;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.tsp.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TimestampRequestExample {
    public static void main(String[] args) {
        String tspUrl = "http://timestamping.edelweb.fr/service/tsp";
        byte[] data = "hello".getBytes(); // Your original data

        // Generate SHA-1 hash of the data
        SHA1Digest sha1Digest = new SHA1Digest();
        sha1Digest.update(data, 0, data.length);
        byte[] digest = new byte[sha1Digest.getDigestSize()];
        sha1Digest.doFinal(digest, 0);

        try {
            TimeStampRequestGenerator reqGen = new TimeStampRequestGenerator();
            TimeStampRequest request = reqGen.generate(TSPAlgorithms.SHA1, digest);
            byte[] requestBytes = request.getEncoded();

            URL url = new URL(tspUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/timestamp-query");

            try (OutputStream out = connection.getOutputStream()) {
                out.write(requestBytes);
            }

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
            }

            InputStream in = connection.getInputStream();
            TimeStampResp timeStampResp = TimeStampResp.getInstance(new ASN1InputStream(in).readObject());
            TimeStampResponse response = new TimeStampResponse(timeStampResp);
            response.validate(request);

            System.out.println("Timestamp: " + response.getTimeStampToken().getTimeStampInfo().getGenTime());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}