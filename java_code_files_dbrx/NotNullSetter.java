import java.lang.String;
public class NotNullSetter {
    public void setProperty(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        // proceed with normal code execution.
    }
    public static void main(String[] args) {
    }
}