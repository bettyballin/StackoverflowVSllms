import java.lang.String;

public class CustomToStringCreator {
    public void style(Object value, StringBuilder buffer) {
        // Only include essential information about the object
        buffer.append(value.getClass().getSimpleName()).append("[");
        // Add any other necessary details about the object
        buffer.append("]");
    }

    public static void main(String[] args) {
    }
}