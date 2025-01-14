import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class as {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://yourserver.com/signed.jar");
        URLClassLoader loader = new URLClassLoader(new URL[]{url});

        // Load the specific signed part of your application when needed
        Class<?> sensitivePart = loader.loadClass("com.yourcompany.SensitiveAppletPart");

        // Instantiate and use the loaded class as required
        Object appletComponent = sensitivePart.getDeclaredConstructor().newInstance();
    }
}