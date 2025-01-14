import java.lang.String;
public class ParameterStringBuilder {
    public String buildDelimitedString(String... elements) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && !elements[i].isEmpty()) {
                if (sb.length() > 0) sb.append(",");
                sb.append(elements[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Usage
        boolean condition = true; // Replace with actual condition
        boolean anotherCondition = false; // Replace with actual condition

        ParameterStringBuilder psb = new ParameterStringBuilder();

        String parameterString = psb.buildDelimitedString(
            condition ? "elementName" : "",
            anotherCondition ? "anotherElementName" : ""
        );

        System.out.println(parameterString);
    }
}