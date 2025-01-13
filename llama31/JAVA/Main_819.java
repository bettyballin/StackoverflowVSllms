import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Main_819 {
    public static String buildDelimitedString(List<String> elements, String delimiter) {
        StringJoiner sj = new StringJoiner(delimiter);
        for (String element : elements) {
            sj.add(element);
        }
        return sj.toString();
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