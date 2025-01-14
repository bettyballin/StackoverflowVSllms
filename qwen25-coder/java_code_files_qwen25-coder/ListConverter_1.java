import java.util.List;
import java.util.stream.Collectors;

public class ListConverter_1 {
    public static <ObjectType> List<ObjectType> convertList(List<?> sourceList) {
        // Use streams to cast and collect elements
        return sourceList.stream()
                .map(element -> (ObjectType) element)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
    }
}