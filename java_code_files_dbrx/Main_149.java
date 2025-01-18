import java.util.*;

public class Main {
    static boolean condition;
    static boolean anotherCondition;

    public static void main(String[] args) {
        List<String> parameterList = new ArrayList<>();

        if (condition) parameterList.add("elementName");
        if (anotherCondition) parameterList.add("anotherElementName");
        String delimiter = ",";
        String parameterString = String.join(delimiter, parameterList);

        System.out.println(parameterString);
    }
}