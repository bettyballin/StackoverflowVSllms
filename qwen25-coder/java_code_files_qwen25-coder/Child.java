import java.io.ObjectOutputStream;
import java.io.NotSerializableException;
import java.io.IOException;

public class Child extends Parent {
    private void writeObject(ObjectOutputStream out) throws IOException {
        throw new NotSerializableException("This object is not serializable");
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}

// Assuming Parent class is defined elsewhere.
// If not, you can define a minimal Parent class for compilation.
class Parent {
    // Parent class content
}