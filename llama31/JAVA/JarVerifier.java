import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;

public class JarVerifier {
    public static void main(String[] args) {
        File jarFile = new File("myapp.jar");
        try {
            JarFile jf = new JarFile(jarFile);
            if (!jf.isSigned()) {
                System.out.println("JAR file is not signed");
                System.exit(1);
            }
            // You can also verify the signer's certificate
            // jf.getSigners().get(0).getCertificate();
        } catch (IOException e) {
            System.err.println("Error opening JAR file: " + e.getMessage());
            System.exit(1);
        }
    }
}