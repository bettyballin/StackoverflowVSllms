import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class AttributeFormatter {
    public static void main(String[] args) {
        AttributeFormatter formatter = new AttributeFormatter();
        Map<String, String> tagAttrs = new HashMap<>();
        tagAttrs.put("attr", "value");
        String attr = "attr";
        String attrd = String.format("%s='%s'", attr, tagAttrs.get(attr));
        System.out.println(attrd);
    }
}