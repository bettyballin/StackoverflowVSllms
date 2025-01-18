import java.lang.String;
public class Monitor {
    int varX; // shared resource that tasks manipulate in this case

    public void TaskA() {
        synchronized(this) {
            updateVarX();  // TaskA only manipulates shared resource without any other task interference or wait time for lock release
        }
    }

    public void TaskB() {
        // similar to above for each of the remaining tasks.
    }

    void updateVarX() {
        // Implement the method as needed
    }

    public static void main(String[] args) {
    }
}