import java.lang.String;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Convert;
import javax.persistence.AttributeConverter;

@Entity
public class YourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Convert(converter = UUIDConverter.class)
    private UUID id;

    // other fields and methods ...
}

class UUIDConverter implements AttributeConverter<UUID, byte[]> {
    @Override
    public byte[] convertToDatabaseColumn(UUID attribute) {
        if (attribute == null) return null;
        return getBytesFromUUID(attribute);
    }

    @Override
    public UUID convertToEntityAttribute(byte[] dbData) {
        if (dbData == null || dbData.length != 16) {
            throw new IllegalArgumentException("Invalid binary data provided");
        }
        return UUID.nameUUIDFromBytes(dbData);
    }

    private byte[] getBytesFromUUID(UUID uuid) {
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();
        byte[] buffer = new byte[16];
        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte)(msb >>> 8 * (7 - i));
        }
        for (int i = 8; i < 16; i++) {
            buffer[i] = (byte)(lsb >>> 8 * (15 - i));
        }
        return buffer;
    }

	public static void main(String[] args) {
	}
}