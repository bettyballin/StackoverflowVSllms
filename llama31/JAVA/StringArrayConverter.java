import java.lang.String;
import java.util.Arrays;
import java.util.List;

public class StringArrayConverter {
    List<?> l = Arrays.asList("a", "b", "c");
    String[] stuff = l.toArray(new String[0]);

    public static void main(String[] args) {
        StringArrayConverter converter = new StringArrayConverter();
        System.out.println(Arrays.toString(converter.stuff));
    }
}