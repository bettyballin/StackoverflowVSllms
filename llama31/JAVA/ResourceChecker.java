import java.io.File;
import java.net.URL;

public class ResourceChecker {
    public static void main(String[] args) {
        String resourceName = "/ggla/samples/obj/linux_x86/your_executable";
        URL resourceUrl = ResourceChecker.class.getResource(resourceName);
        if (resourceUrl != null) {
            File file = new File(resourceUrl.getFile());
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}