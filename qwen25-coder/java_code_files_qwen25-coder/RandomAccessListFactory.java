import java.util.ArrayList;
import java.lang.String;
import java.util.List;

public class RandomAccessListFactory {
    public List<String> foo() {
        // If the list is primarily accessed randomly, ArrayList will perform better than LinkedList.
        List<String> list = new ArrayList<>();
        // ... populate the list
        return list;
    }
    public static void main(String[] args) {
    }
}