import java.lang.String;
public class Preloader {
    public static void preloadClasses(String... classes) throws Exception {
        for (String className : classes) {
            try {
                // Use Class.forName() to load the class, this will trigger its initialisation.
                @SuppressWarnings("unused")
                Class<?> loadedClass = Class.forName(className);
            } catch (Exception e) {
                throw new Exception("Failed to preload class " + className, e);
            }
        }
    }

	public static void main(String[] args) {
	}
}