import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicLoader {
    public void loadJar(String jarPath) throws Exception {
        URL url = new URL("file:" + jarPath);
        URL[] urls = {url};
        ClassLoader loader = new URLClassLoader(urls, Thread.currentThread().getContextClassLoader());
        
        // Example: Load a class from the JAR
        Class<?> loadedClass = loader.loadClass("com.example.YourClassName");
        System.out.println("Loaded class: " + loadedClass.getName());
    }

	public static void main(String[] args) {
	}
}