import java.lang.String;
import java.util.UUID;
import java.time.Instant;

public class UniqueFileNameGenerator {
    public static String generateUniqueFileName() {
        Instant timestamp = Instant.now();
        UUID uuid = UUID.randomUUID();
        String uniqueFileName = timestamp.toEpochMilli() + "-" + uuid.toString();
        return uniqueFileName;
    }

	public static void main(String[] args) {
	}
}