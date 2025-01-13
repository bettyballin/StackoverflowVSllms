import java.util.ArrayList;
import java.util.List;

public class Main_763_763 {
    public static void main(String[] args) {
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");

        String commaDelimited = String.join(",", ids);
        System.out.println(commaDelimited);
    }
}