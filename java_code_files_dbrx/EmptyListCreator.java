import java.util.List;
import java.util.ArrayList;

public class EmptyListCreator {
    List<Integer> myList = createEmptyList(); // Compiles and works as expected

    public static void main(String[] args) {
    }

    public List<Integer> createEmptyList() {
        return new ArrayList<Integer>();
    }
}