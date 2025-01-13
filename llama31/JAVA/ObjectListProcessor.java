import java.util.List;
import java.util.stream.Collectors;

class YourObject {
    // Assuming you have a proper implementation of equals() and hashCode() methods
    // For simplicity, let's just override toString() for demonstration purposes
    @Override
    public String toString() {
        return "YourObject";
    }
}

public class ObjectListProcessor {
    public static void main(String[] args) {
        List<YourObject> yourObjectList = List.of(new YourObject(), new YourObject(), new YourObject());
        List<YourObject> distinctList = yourObjectList.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println(distinctList);
    }
}