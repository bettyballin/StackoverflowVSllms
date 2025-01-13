import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class ThreadIsolation_1_1 {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            try {
                URLClassLoader cl = URLClassLoader.newInstance(new URL[]{/* URLs to classes */});
                Class<?> clazz = cl.loadClass("com.example.MyClass");
                // Use the loaded class
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                URLClassLoader cl = URLClassLoader.newInstance(new URL[]{/* URLs to classes */});
                Class<?> clazz = cl.loadClass("com.example.MyClass");
                // Use the loaded class
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        });

        thread1.start();
        thread2.start();
    }
}