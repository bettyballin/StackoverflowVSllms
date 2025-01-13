import java.util.HashSet;
import java.util.Set;

public class SynchronizationDetector {
    private static final ThreadLocal<Set<String>> threadAccessedMethods = new ThreadLocal<>();
    private static final InheritableThreadLocal<Boolean> isThreadSafe = new InheritableThreadLocal<>();

    public static void markAsThreadSafe() {
        isThreadSafe.set(true);
    }

    public static void markAsNotThreadSafe() {
        isThreadSafe.set(false);
    }

    public static void recordMethodAccess(String methodName) {
        if (!isThreadSafe.get()) {
            Set<String> accessedMethods = threadAccessedMethods.get();
            if (accessedMethods == null) {
                accessedMethods = new HashSet<>();
                threadAccessedMethods.set(accessedMethods);
            }
            if (accessedMethods.contains(methodName)) {
                throw new RuntimeException("Synchronization violation detected: multiple threads accessing method " + methodName);
            }
            accessedMethods.add(methodName);
        }
    }

    public static void main(String[] args) {
    }
}