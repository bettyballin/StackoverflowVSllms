import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EmptyStringToNullConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return attribute == null || attribute.isEmpty() ? null : attribute;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData == null ? "" : dbData;
    }

    public static void main(String[] args) {
        // Example usage
        EmptyStringToNullConverter converter = new EmptyStringToNullConverter();
        System.out.println(converter.convertToDatabaseColumn("")); // Should print: null
        System.out.println(converter.convertToDatabaseColumn("Hello")); // Should print: Hello
        System.out.println(converter.convertToEntityAttribute(null)); // Should print: ""
        System.out.println(converter.convertToEntityAttribute("World")); // Should print: World
    }
}