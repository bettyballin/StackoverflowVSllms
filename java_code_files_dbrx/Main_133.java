import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        List<YourClass> list = new ArrayList<>(); // your initial list
        // Add elements to the list
        list.add(new YourClass());
        list.add(new YourClass());
        
        Set<YourClass> set = new HashSet<>();
        set.addAll(list);
    }
}

class YourClass {
    // YourClass implementation
}