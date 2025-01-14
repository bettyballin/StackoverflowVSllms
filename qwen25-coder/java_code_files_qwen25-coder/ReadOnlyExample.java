import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ReadOnlyExample {
    private final List<String> readOnlyList;

    public ReadOnlyExample() {
        List<String> tempList = new ArrayList<>();
        // Add initial items to the list
        tempList.add("item1");
        tempList.add("item2");

        // Make the list unmodifiable
        readOnlyList = Collections.unmodifiableList(tempList);
    }

    public List<String> getReadOnlyList() {
        return readOnlyList;
    }

    public static void main(String[] args) {
    }
}