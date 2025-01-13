import java.lang.String;
import java.util.ArrayList;

public class LoopOptimizationExample {
    public static void main(String[] args) {
        ArrayList<String> collection = new ArrayList<>();
        // Inefficient
        for (int i = 0; i < collection.size(); i++) {
            // ...
        }

        // Efficient
        int size = collection.size();
        for (int i = 0; i < size; i++) {
            // ...
        }
    }
}