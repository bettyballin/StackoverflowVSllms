import java.util.UUID;

public class UUIDConverter implements AttributeConverter<UUID, String> {
    public String convertToDatabaseColumn(UUID locId) {
        return locId == null ? null : locId.toString(); // or use any other suitable method to format UUID into string representation
    }
    public UUID convertToEntityAttribute(String dbData) {
        return dbData == null ? null : UUID.fromString(dbData); // or use any other suitable method to parse string representation of uuid
    }

    public static void main(String[] args) {
    }
}

interface AttributeConverter<X, Y> {
    public Y convertToDatabaseColumn(X attribute);
    public X convertToEntityAttribute(Y dbData);
}