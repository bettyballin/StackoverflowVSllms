import java.io.File;
import java.security.CodeSource;

public class Main_356 {
    public static void main(String[] args) throws Exception {
        CodeSource src = Main_356.class.getProtectionDomain().getCodeSource();
        if (src != null) {
            System.out.println("Path : " + new File(Main_356.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getCanonicalFile());
        } else {
            throw new RuntimeException("The security manager does not allow access to the codebase.");
        }
    }
}