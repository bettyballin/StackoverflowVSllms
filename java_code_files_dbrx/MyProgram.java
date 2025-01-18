import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.util.encoders.Base64;
import java.io.FileInputStream;
import java.io.IOException;

public class MyProgram {
    public static void main(String[] args) {
        byte[] buffer = new byte[8 * 1024]; // Adjust size to read large certificates
        int bytesRead;
        try (final FileInputStream inStream = new FileInputStream("certificate.pem")) {
            while ((bytesRead = inStream.read(buffer)) != -1) {
                System.out.println(new String(Base64.encode(buffer)));
            }
        } catch (IOException e) {
            // Handle exception according to your implementation requirements
            e.printStackTrace();
        }
    }
}