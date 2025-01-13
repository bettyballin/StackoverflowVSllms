import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectTypeMapper {
    public static void main(String[] args) {
        List<ObjectType> resultList = List.of(new ObjectType(), new ObjectType()); // Replace with your actual resultList
        List<ObjectType> targetList = resultList.stream()
                .map(ObjectType.class::cast)
                .collect(Collectors.toList());
    }
}

// Assuming ObjectType is a custom class
class ObjectType {}