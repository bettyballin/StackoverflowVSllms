import java.util.List;
import java.util.stream.Collectors;

public class ListConverter {
    public static <ObjectType> List<ObjectType> safeConvertList(List<?> sourceList, Class<ObjectType> clazz) {
        // Use streams with a filter and cast to ensure type safety
        return sourceList.stream()
                .filter(clazz::isInstance)
                .map(element -> (ObjectType) element)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
    }
}