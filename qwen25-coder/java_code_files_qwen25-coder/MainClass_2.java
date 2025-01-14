import java.util.Arrays;
import java.util.List;

public class MainClass_2 {
    public static void main(String args[]) {
        // Declare list with String as its generic type
        List<String> l = Arrays.asList("a", "b", "c");
        String stuff[] = l.toArray(new String[0]);
        System.err.println(Arrays.asList(stuff));
    }
}