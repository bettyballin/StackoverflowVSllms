import java.lang.String;
public class BranchPredictor {
    // Compile-time: The compiler cannot know which path will execute more frequently.
    public void process(int condition) {
        if (condition == 1) { // Rarely true
            // Complex and slow computation here
        } else {
            // Simple and fast operation here
        }
    }

    // At runtime, the VM can detect that 'else' is almost always taken, allowing it to optimize accordingly.
    public static void main(String[] args) {
    }
}