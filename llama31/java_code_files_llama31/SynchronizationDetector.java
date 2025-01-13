/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;
import java.util.Set;

public class SynchronizationDetector {
    private static final ThreadLocal<Set<String>> threadAccessedMethods = new ThreadLocal();
    private static final InheritableThreadLocal<Boolean> isThreadSafe = new InheritableThreadLocal();

    public static void markAsThreadSafe() {
        isThreadSafe.set(true);
    }

    public static void markAsNotThreadSafe() {
        isThreadSafe.set(false);
    }

    public static void recordMethodAccess(String string) {
        if (!((Boolean)isThreadSafe.get()).booleanValue()) {
            Set<String> set = threadAccessedMethods.get();
            if (set == null) {
                set = new HashSet<String>();
                threadAccessedMethods.set(set);
            }
            if (set.contains(string)) {
                throw new RuntimeException("Synchronization violation detected: multiple threads accessing method " + string);
            }
            set.add(string);
        }
    }

    public static void main(String[] stringArray) {
    }
}
