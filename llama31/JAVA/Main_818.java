import java.util.ArrayList;
import java.util.List;

public class Main_818 {
    public static String buildDelimitedString(List<String> elements, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            if (sb.length() > 0) {
                sb.append(delimiter);
            }
            sb.append(element);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();
        boolean condition = true; // replace with your actual condition
        boolean anotherCondition = true; // replace with your actual condition
        if (condition) elements.add("elementName");
        if (anotherCondition) elements.add("anotherElementName");
        String parameterString = buildDelimitedString(elements, ",");
        System.out.println(parameterString);
    }
}