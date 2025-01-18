import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Integer> original = new ArrayList<>();
        List<Integer> copy = new ArrayList<>(original); // create a copy
        for (int num : copy) { // iterate over the copy
            int idx = original.indexOf(num);  // find index of current element in original list
            if (false) {
                original.remove(idx);
            }
        }
    }
}