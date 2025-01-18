import java.lang.reflect.*;
import java.net.*;
import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        List<Class<?>> interfacesImplementations = YourClassLoaderWrapper.<List<Class<?> >>findImplementations("com.yourpackage.YourInterface");
    }
}

class YourClassLoaderWrapper {
    public static <T> T findImplementations(String s) {
        return null;
    }
}