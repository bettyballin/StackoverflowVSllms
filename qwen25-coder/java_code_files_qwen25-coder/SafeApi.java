import java.lang.String;
// Example of graceful error handling in Java
public class SafeApi {
    public void process(Data data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        // processing logic here
    }

    public static void main(String[] args) {
    }
}

class Data {
    // Empty class definition for Data
}