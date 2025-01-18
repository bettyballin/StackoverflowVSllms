import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ObjectType {
    // Empty class
}

public class ObjectTypeCasterorListTypeCaster {
    List<Object> listGeneric = new ArrayList<>();

    final List<ObjectType> castedList = listGeneric.stream()
        .map(obj -> (ObjectType) obj).collect(Collectors.toList());

    public static void main(String[] args) {
    }
}