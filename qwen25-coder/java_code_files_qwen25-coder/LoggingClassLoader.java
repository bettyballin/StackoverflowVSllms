import java.lang.String;
import java.net.URL;
import java.net.URLClassLoader;

public class LoggingClassLoader extends URLClassLoader {
    public LoggingClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("Loading " + name);
        try {
            URL resource = findResource(name.replace('.', '/') + ".class");
            if (resource != null) {
                System.out.println("Found in: " + resource.toString());
            }
            return super.findClass(name);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Could not find class " + name, e);
        }
    }

    public static void main(String[] args) {
    }
}