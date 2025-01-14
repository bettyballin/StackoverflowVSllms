import java.lang.String;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DeployEAR {
    public static void main(String[] args) {
        try {
            File sourceEar = new File("/path/to/your/Foo.ear");
            File destinationDir = new File("/path/to/glassfish/domains/domain1/applications");
            
            Files.copy(sourceEar.toPath(), destinationDir.toPath().resolve("Foo.ear"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("EAR file deployed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}