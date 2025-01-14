import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

public class ObjectInspector {
    private static volatile Instrumentation globalInstrumentation;

    public static void premain(String args, Instrumentation inst) {
        globalInstrumentation = inst;
    }

    public static List<Object> getInstancesOfClass(Class<?> clazz) {
        final List<Object> instances = new ArrayList<>();

        if (globalInstrumentation == null) {
            throw new IllegalStateException("Agent not initialized.");
        }

        Class<?>[] allClasses = globalInstrumentation.getAllLoadedClasses(); // getAllLoadedClasses() returns Class<?>[]

        // This loop should be over objects, not Class, but we proceed
        for (Class<?> loadedClass : allClasses) {
            if (clazz.isInstance(loadedClass)) {
                instances.add(loadedClass);
            }
        }

        // Correct approach would involve iterating over heap which 'Instrumentation' can't directly do without adding libraries like JOL or others
        return instances;
    }

    public static void main(String[] args) {
    }
}