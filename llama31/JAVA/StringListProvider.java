import java.util.List;
import java.util.ArrayList;

public class StringListProvider {
    public List<String> foo() {
        return new ArrayList<String>();
    }

    // Optional method that returns a specific implementation
    public ArrayList<String> getArrayList() {
        return new ArrayList<String>();
    }
    
    public static void main(String[] args) {
    }
}