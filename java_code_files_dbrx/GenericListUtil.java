import java.lang.String;
import java.util.List;

public class GenericListUtil {
    List<?> listGeneric = yourMethod(); // Get the List<?>, this could be from any method call or operation
    List<ObjectType> castedList = (List<ObjectType>) listGeneric;

    public static void main(String[] args) {
    }

    public List<?> yourMethod() {
        return null; // Placeholder implementation
    }

    class ObjectType {
        // Define ObjectType properties and methods here
    }
}