import java.lang.String;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class ForceJVMCrash {
    public static void main(String[] args) {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);

            // This will likely cause a JVM crash by corrupting memory
            unsafe.putInt(0L, 42);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}