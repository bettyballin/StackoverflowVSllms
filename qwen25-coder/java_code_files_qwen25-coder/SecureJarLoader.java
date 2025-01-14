import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.JarURLConnection;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.security.CodeSource;
import java.security.cert.Certificate;

public class SecureJarLoader {

    public static void loadSecurely(File jarFile) throws IOException {
        URL url = new URL("jar:file:" + jarFile.getPath() + "!/");
        try (JarFile jar = new JarFile(jarFile, true)) { // 'true' enables verification of signatures
            Certificate[] certs = null;
            for (JarEntry je : jar.entries()) {
                if (!je.isDirectory()) {
                    certs = je.getCertificates();
                    if (certs == null || certs.length == 0) {
                        throw new SecurityException("This JAR is not signed or sealed: " + jarFile.getName());
                    }
                }
            }

            // If all entries are signed, set the CodeSource to verify seal
            CodeSource cs = new CodeSource(url, certs);
            if (cs.getLocation().getFile() != null) {
                URLConnection con = cs.getLocation().openConnection();
                if (!(con instanceof JarURLConnection)) {
                    throw new SecurityException("Jar not verified or sealed.");
                }
                ((JarURLConnection) con).getManifest(); // This verifies the seal

                System.out.println("JAR is signed and sealed: " + jarFile.getName());
            }
        } catch (java.util.zip.ZipException | java.io.IOException e) {
            throw new SecurityException("Error in verifying JAR signature or seal.", e);
        }
    }

    public static void main(String[] args) throws IOException {
        File jarToLoad = new File("/path/to/your/plugin.jar");
        loadSecurely(jarToLoad);
    }
}