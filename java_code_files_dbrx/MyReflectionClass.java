import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Objects;

public class MyReflectionClass {

    public Object recursiveReflectionCall(String[] pathElements, String methodOrPropertyName, Class<?> parameterTypes[], Object[] args) {
        // Initialize a starting object from the first element in path
        Object currentObject = this;

        // Iterate through the remaining elements of path
        for (int i = 1; i < pathElements.length - 1; ++i) {
            String fieldName = pathElements[i];
            try {
                Field classField = currentObject.getClass().getDeclaredField(fieldName);
                classField.setAccessible(true); // Allows access to private / protected fields
                currentObject = classField.get(currentObject);
            } catch (Exception e) { /* You should log this exception */ }
        }
        String finalFieldNameOrMethodName = pathElements[pathElements.length - 1];

        Object instanceToEvaluate = null;
        try {
            // For the last part of the path, if there's a method call
            if (args != null) {
                Method[] allMethods = currentObject.getClass().getDeclaredMethods();
                for (Method m : allMethods) {
                    if (!m.isAccessible()) {
                        m.setAccessible(true); // Allows use of private/protected methods too
                    }
                    if (m.getName().equals(finalFieldNameOrMethodName) && Arrays.deepEquals(m.getParameterTypes(), parameterTypes)) {
                        return m.invoke(currentObject, args);  // Invoke method and return the result directly
                    }
                }
            } else { // If there isn't a method call but a property evaluation
                Field lastField = currentObject.getClass().getDeclaredField(finalFieldNameOrMethodName);
                lastField.setAccessible(true); // Allows access to private / protected fields
                instanceToEvaluate = lastField.get(currentObject);
            }
        } catch (Exception e) { /* You should log this exception */ }

        return Objects.isNull(methodOrPropertyName) ? instanceToEvaluate : null;
    }

    public static void main(String[] args) {
        // Code to test the recursiveReflectionCall method
    }
}