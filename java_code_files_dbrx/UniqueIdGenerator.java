import java.lang.String;
import java.util.UUID;
public class UniqueIdGenerator {
    String uuid = UUID.randomUUID().toString().replace("-", "");
    public static void main(String[] args) {
    }
}