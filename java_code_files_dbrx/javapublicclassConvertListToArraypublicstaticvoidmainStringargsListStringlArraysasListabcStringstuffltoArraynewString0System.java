import java.lang.String;
import java.util.List;
import java.util.Arrays;

public class ConvertListToArray {
    public static void main(String[] args) {
        List<String> l = Arrays.asList("a", "b", "c");
        String stuff[] = l.toArray(new String[0]);
        System.out.println(Arrays.toString(stuff));
    }
}