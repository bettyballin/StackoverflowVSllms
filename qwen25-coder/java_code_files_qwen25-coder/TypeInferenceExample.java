import java.util.List;
import java.util.ArrayList;

public class TypeInferenceExample {
    Object myObject = createEmptyList(); // This works but infers Object as T

    // To explicitly pass Integer as the type argument:
    List<Integer> myList = createEmptyList();

    public static void main(String[] args) {
    }

    public static <T> List<T> createEmptyList() {
        return new ArrayList<T>();
    }
}