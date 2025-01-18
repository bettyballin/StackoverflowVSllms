import java.util.List;
import java.util.Arrays;

public class StringPrinter {

    static List<String> names = Arrays.asList("Peter", "Paul", "Mary");

    static {
        names.forEach(name -> System.out.println(name));
    }

    public static void main(String[] args) {
    }
}