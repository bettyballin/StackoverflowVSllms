import java.util.Map;

public class Configuration_1_1 {
    @Convert(converter = MapToJsonConverter.class)
    private Map<String, String> myMap;

    public static void main(String[] args) {
    }
}

// Note: The @Convert annotation and MapToJsonConverter class are not part of the standard Java API.
// You would need to define or import these from a library that provides them.

// For example, if you're using JPA (Java Persistence API), you would import the @Convert annotation like this:
// import javax.persistence.Convert;

// And define the MapToJsonConverter class like this:
// import javax.persistence.AttributeConverter;
// import javax.persistence.Converter;
// 
// @Converter
// public class MapToJsonConverter implements AttributeConverter<Map<String, String>, String> {
//     // Implement the convertToDatabaseColumn and convertToEntityAttribute methods
// }