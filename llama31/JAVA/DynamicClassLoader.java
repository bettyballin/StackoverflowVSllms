import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.ToolProvider;

public class DynamicClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        String[] args1 = new String[] {"-cp", System.getProperty("java.class.path"), "YourMainClass"};
        int compilationResult = compiler.run(null, null, null, args1);

        if (compilationResult == 0) {
            URLClassLoader classLoader = new URLClassLoader(new URL[] {new File(System.getProperty("java.class.path")).toURI().toURL()});
            Class<?> clazz = classLoader.loadClass("YourMainClass");
            // Use the loaded class
            Constructor<?> constructor = clazz.getConstructor();
            Object instance = constructor.newInstance();
            // You can invoke methods on the instance here
        }
    }
}