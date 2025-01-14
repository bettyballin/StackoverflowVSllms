// Import statements
import sun.misc.Unsafe;
import java.lang.reflect.Field;
import java.util.ArrayList;

// Example 1: Native Code (JNI) - This is a placeholder for invoking bad native code.
public class Crasher {
    static {
        System.loadLibrary("crashlib");
    }

    public native void crash();

    public static void main(String[] args) {
        new Crasher().crash();
    }
}

// Example 2: Using sun.misc.Unsafe (not recommended)
class UnsafeCrasher {
    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        // Writing to an arbitrary memory location, which can crash the JVM
        unsafe.putInt(0xdeadbeef, 42);
    }
}

// Example 3: Stack Overflow
class StackOverflowCrasher {
    public static void main(String[] args) {
        recurse();
    }

    private static void recurse() {
        recurse(); // This will eventually cause a StackOverflowError
    }
}

// Example 4: Out of Memory
class OOMCrasher {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object()); // Keep adding objects until memory is exhausted
        }
    }
}