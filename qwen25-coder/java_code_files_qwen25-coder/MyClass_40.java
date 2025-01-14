import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyClass {
    boolean condition = true;          // Set to true or false as needed
    boolean anotherCondition = false;  // Set to true or false as needed

    public String buildDelimitedString() {
        return Stream.of(
            condition ? "elementName" : null,
            anotherCondition ? "anotherElementName" : null
        )
        .filter(e -> e != null)
        .collect(Collectors.joining(","));
    }

    // Usage
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        String parameterString = obj.buildDelimitedString();
        System.out.println(parameterString);
    }
}