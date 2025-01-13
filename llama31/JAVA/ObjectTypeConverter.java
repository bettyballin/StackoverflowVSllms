import java.util.List;
import java.util.stream.Collectors;

public class ObjectTypeConverter {
    List<ObjectType> targetList;

    public ObjectTypeConverter(List<?> resultList) {
        targetList = resultList.parallelStream()
                .map(ObjectType.class::cast)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // You need to have ObjectType class and resultList to test this class
        // ObjectTypeConverter converter = new ObjectTypeConverter(resultList);
    }
}