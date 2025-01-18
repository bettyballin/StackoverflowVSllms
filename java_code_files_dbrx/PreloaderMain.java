import java.lang.String;

public class PreloaderMain {
    public static void main(String[] args) {
        try {
            // Preload classes here by using class's fully-qualified names (FQNs).
            Preloader.preloadClasses("com.example.Class1", "com.example.Class2");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

class Preloader {
    public static void preloadClasses(String... classNames) throws ClassNotFoundException {
        for (String className : classNames) {
            Class.forName(className);
        }
    }
}