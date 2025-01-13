import java.util.Arrays;

public class MemoryEraser {
    public static void secureErase(Object[] data) {
        if (data == null) {
            return;
        }
        Arrays.fill(data, null);
    }
    public static void main(String[] args) {
    }
}