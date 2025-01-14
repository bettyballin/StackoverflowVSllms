import java.util.List;
import java.util.ArrayList;

public class GenericTypeInference {

    public <T> List<T> createEmptyList() {
        return new ArrayList<>();
    }

    Object myObject = createEmptyList(); // This works, but T is inferred as Object

    // If you want to be explicit about the type parameter:
    List<Integer> integerList = createEmptyList();
    Object myListOfIntegers = integerList; // Assigning a List<Integer> to an Object

    public static void main(String[] args) {
    }
}