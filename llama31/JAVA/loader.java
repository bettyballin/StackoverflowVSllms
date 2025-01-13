import java.lang.reflect.Method;

// Define a custom class loader
class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // Replace this with your own class loading logic
        return super.findClass(name);
    }
}

public class loader {
    public static void main(String[] args) throws Exception {
        // Create a custom class loader
        CustomClassLoader cl = new CustomClassLoader();

        // Load and execute the Java program multiple times
        for (int i = 0; i < 5; i++) {
            Class<?> clazz = cl.loadClass("MyJavaProgram");
            Object instance = clazz.newInstance();
            Method mainMethod = clazz.getMethod("main", String[].class);
            mainMethod.invoke(instance, (Object) new String[0]);
        }
    }
}