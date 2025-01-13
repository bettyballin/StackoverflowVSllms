import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

public class SubclassFinder_2_2 {
    public static List<Class<?>> getSubclasses(Class<?> clazz, Instrumentation instrumentation) {
        List<Class<?>> subclasses = new ArrayList<>();

        for (Class<?> c : instrumentation.getAllLoadedClasses()) {
            if (clazz.isAssignableFrom(c) && !clazz.equals(c)) {
                subclasses.add(c);
            }
        }

        return subclasses;
    }

    public static void main(String[] args) {
        // Note: To actually use the Instrumentation API, you need to implement
        // a Java Agent and load it with the JVM. This main method as is will not
        // be able to use the instrumentation functionality without further setup.
    }
}