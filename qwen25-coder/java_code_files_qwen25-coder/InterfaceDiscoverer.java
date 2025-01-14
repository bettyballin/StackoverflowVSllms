import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class InterfaceDiscoverer {

    public static List<Class<?>> findClassesImplementingInterface(Class<?> interfaceClass, String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName, interfaceClass));
        }
        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName, Class<?> interfaceClass)
            throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName(), interfaceClass));
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                Class<?> c = Class.forName(className);
                if (interfaceClass.isAssignableFrom(c) && !interfaceClass.equals(c)) {
                    classes.add(c);
                }
            }
        }
        return classes;
    }

    public static void main(String[] args) {
        try {
            List<Class<?>> implementingClasses = findClassesImplementingInterface(MyInterface.class, "com.example");
            for (Class<?> c : implementingClasses) {
                System.out.println("Found: " + c.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

interface MyInterface {
    // Interface definition
}