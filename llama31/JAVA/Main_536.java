import java.util.List;
import java.util.stream.Collectors;

class MyObject {
    public boolean matchesMyCriteria() {
        // Implement your criteria here
        return true; // Replace with your actual logic
    }
    
    @Override
    public String toString() {
        return "MyObject";
    }
}

public class Main_536 {
    public static void main(String[] args) {
        List<MyObject> myList = List.of(new MyObject(), new MyObject()); // Initialize your list

        List<MyObject> filteredList = myList.stream()
                .filter(obj -> obj.matchesMyCriteria())
                .collect(Collectors.toList());

        // Do something with filteredList
        System.out.println(filteredList);
    }
}