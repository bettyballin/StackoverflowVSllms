import java.lang.String;
import java.io.File;
    import java.security.cert.Certificate;
    import java.util.jar.JarEntry;
    import java.util.jar.JarFile;

    public class JarVerifier {
        public static void main(String[] args) throws Exception {
            File jarPath = new File("path/to/your/myapp.jar");
            JarFile jar = new JarFile(jarPath, true);
            JarEntry entry = jar.getJarEntry("Main-Class-Name.class"); // Change to your actual entry
            Certificate[] certs = entry.getCertificates();
            
            if (certs == null) {
                throw new SecurityException("Jar not signed!");
            }
            System.out.println("JAR is signed with certificates: " + java.util.Arrays.toString(certs));
        }
    }
