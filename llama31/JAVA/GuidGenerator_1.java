import java.lang.String;
import java.util.UUID;

public class GuidGenerator_1 {
    public static String generateGuid() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(generateGuid());
    }
}