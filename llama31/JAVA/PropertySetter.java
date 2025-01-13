import java.lang.String;

public class PropertySetter {
    public void setProperty(Object property) {
        if (property == null) {
            throw new NullPointerException("Property cannot be null");
        }
        // rest of the method implementation
    }

    public static void main(String[] args) {
        // To test the class, you can create an instance and call the method
        PropertySetter setter = new PropertySetter();
        setter.setProperty("Test Property");
    }
}