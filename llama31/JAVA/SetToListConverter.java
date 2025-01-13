import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class SetToListConverter {
    public static void main(String[] args) {
        SetToListConverter converter = new SetToListConverter();
        converter.convertSetToList();
    }

    public void convertSetToList() {
        Set<String> mySet = new HashSet<>();
        mySet.add("Hello");
        mySet.add("World");

        // Convert the set to a list
        List<String> myList = new ArrayList<>(mySet);

        // Access elements by index
        String firstElement = myList.get(0);
        System.out.println(firstElement);
    }
}