import java.lang.String;
import sun.misc.Unsafe;

public class CrashJVM {
    public static void main(String[] args) {
        Unsafe unsafe = getUnsafe();
        unsafe.putAddress(0, 0); // will crash the JVM
    }

    private static Unsafe getUnsafe() {
        try {
            return (Unsafe) Class.forName("sun.misc.Unsafe").newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}