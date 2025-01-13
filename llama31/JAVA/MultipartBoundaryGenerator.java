import java.lang.String;
import java.util.UUID;

public class MultipartBoundaryGenerator {
    String boundary = "---------------------------" + UUID.randomUUID().toString();
    public static void main(String[] args) {
    }
}