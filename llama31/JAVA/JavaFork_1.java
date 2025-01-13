import java.lang.String;
import java.io.IOException;

public class JavaFork_1 {
    public static void main(String[] args) throws IOException {
        // Create a new process
        Runtime.getRuntime().exec("java -cp " + System.getProperty("java.class.path") + " IndependentProcess");
    }
}