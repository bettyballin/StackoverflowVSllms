import java.util.List;
import java.util.ArrayList;

public class Main_812_812 {

    public static void main(String[] args) {
        List<Integer> myList = createEmptyList(); // OK
    }

    static <T> List<T> createEmptyList() {
        return new ArrayList<T>();
    }
}