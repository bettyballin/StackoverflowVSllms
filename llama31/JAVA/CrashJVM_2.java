import java.util.List;
import java.util.ArrayList;

public class CrashJVM_2_2 {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        while (true) {
            list.add(new byte[1024 * 1024]); // allocate 1MB at a time
        }
    }
}