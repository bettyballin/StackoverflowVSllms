import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class Main_393_393 {
    public static void main(String[] args) throws Exception {
        Unsafe unsafe = getUnsafe();
        int fd = unsafe.open("path/to/file", 0); // O_RDONLY
        // use the file descriptor
        unsafe.close(fd);
    }

    private static Unsafe getUnsafe() throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }
}