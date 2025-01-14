import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Convert;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Entity
public class Deal {

    @Id
    private Long id;

    @Convert(converter = DealTypeConverter.class)
    private DealType type;

    // getters and setters can be added here

    public static void main(String[] args) {
        // main method implementation
    }
}

// Define DealType enum
enum DealType {
    TYPE_A,
    TYPE_B
}

// Implement DealTypeConverter
@Converter
class DealTypeConverter implements AttributeConverter<DealType, String> {

    @Override
    public String convertToDatabaseColumn(DealType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.name();
    }

    @Override
    public DealType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            return DealType.valueOf(dbData);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}