import java.util.HashMap;
import java.util.Map;

public class AttrFormatter {
    Map<String, String> tagAttrs = new HashMap<>();

    String attrd = String.format("%s='%s'", "attr", tagAttrs.get("attr"));

    public static void main(String[] args) {
        AttrFormatter formatter = new AttrFormatter();
        formatter.tagAttrs.put("attr", "value");
        System.out.println(formatter.attrd);
    }
}