import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class SetToListConverter {
   Set<String> set = new HashSet<>();
   // Assume set is populated
   List<String> list = new ArrayList<>(set);
   String firstElement = list.get(0); // Access by index

   public static void main(String[] args) {
   }
}