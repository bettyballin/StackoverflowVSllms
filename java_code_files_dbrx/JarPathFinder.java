import java.lang.String;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.io.File;

public class JarPathFinder {
    public static void main(String[] args) {
        CodeSource codeSource = JarPathFinder.class.getProtectionDomain().getCodeSource();
        File jarFile;
        try {
            jarFile = new File(codeSource.getLocation().toURI());
            String absolutePath = jarFile.getAbsolutePath();
            System.out.println("Jar file path: " + absolutePath);
        } catch (URISyntaxException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}