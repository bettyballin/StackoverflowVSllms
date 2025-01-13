import java.io.InputStream;
import java.lang.String;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResourceLoader_1_1 {
    public static void main(String[] args) {
        // Using ClassLoader
        ClassLoader classLoader = ResourceLoader_1.class.getClassLoader();
        InputStream resourceStream1 = classLoader.getResourceAsStream("my-resource.properties");

        // Using Resource API
        Resource resource = new ClassPathResource("my-resource.properties");
        try {
            InputStream resourceStream2 = resource.getInputStream();
        } catch (Exception e) {
            // Handle exception
        }
    }
}