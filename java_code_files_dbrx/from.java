import java.lang.String;

public class from {
    // assuming MySuperClass and TestClass are defined in your project
    public void someMethod(String className) {
        try {
            Class<?> givenClass = Class.forName(className); // Load the given class from its name
            if (MySuperClass.class.isAssignableFrom(givenClass)) {
                // The class is a subclass of MySuperClass; proceed as needed...
            } else {
                throw new IllegalArgumentException("Invalid class: must be a subtype of 'MySuperClass'");
            }
        } catch (ClassNotFoundException e) {
            // Handle the case when given string does not match any existing class name
            throw new IllegalArgumentException("Invalid class name: " + className, e);
        }
    }

    public static void main(String[] args) {
    }
}