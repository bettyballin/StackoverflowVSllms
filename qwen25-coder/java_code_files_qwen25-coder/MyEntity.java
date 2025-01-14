import java.lang.String;
import java.util.UUID;
import java.nio.ByteBuffer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Define the Entity annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Entity {
}

// Define the Id annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id {
}

@Entity
public class MyEntity {
    @Id
    private byte[] id;

    // Method to convert UUID to byte[]
    public static byte[] uuidToBytes(UUID uuid) {
        return byteArray(uuid);
    }

    // Convert UUID to byte[]
    private static byte[] byteArray(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    // Constructor for creating a new entity with a generated UUID
    public MyEntity() {
        this.id = uuidToBytes(UUID.randomUUID());
    }

    public static void main(String[] args) {
    }
}