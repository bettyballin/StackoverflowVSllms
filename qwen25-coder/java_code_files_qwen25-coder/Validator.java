import java.lang.String;
public class Validator {
    public void setProperty(String property) {
        if (property == null) {
            throw new IllegalArgumentException("The property cannot be null");
        }
        // Proceed with setting the property
    }
    public static void main(String[] args) {
    }
}