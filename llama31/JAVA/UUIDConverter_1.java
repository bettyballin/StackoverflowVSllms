import java.nio.ByteBuffer;
import java.util.UUID;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UUIDConverter_1_1 implements AttributeConverter<UUID, byte[]> {
    @Override
    public byte[] convertToDatabaseColumn(UUID attribute) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.putLong(attribute.getMostSignificantBits());
        buffer.putLong(attribute.getLeastSignificantBits());
        return buffer.array();
    }

    @Override
    public UUID convertToEntityAttribute(byte[] dbData) {
        ByteBuffer buffer = ByteBuffer.wrap(dbData);
        long mostSignificantBits = buffer.getLong();
        long leastSignificantBits = buffer.getLong();
        return new UUID(mostSignificantBits, leastSignificantBits);
    }

    public static void main(String[] args) {
    }
}