import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;

import your.package.name.YourInterface;

public class InterfaceClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // Get all resources (classes) in the classpath
        ClassLoader cl = YourInterface.class.getClassLoader();
        Enumeration<URL> resources = cl.getResources("your/package/name");

        // Iterate over the resources and check if they implement the interface
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            String className = url.getFile().substring(1).replace('/', '.');
            Class<?> clazz = Class.forName(className);
            if (YourInterface.class.isAssignableFrom(clazz)) {
                Constructor<?> constructor = clazz.getConstructor();
                YourInterface instance = (YourInterface) constructor.newInstance();
                // Use the instance
            }
        }
    }
}