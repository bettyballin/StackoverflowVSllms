import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

public class CallableRunnerClass<T> implements Runnable {
    private ObjectInputStream inputFromParent;
    private Callable<T> x;

    @Override
    public void run() {
        try (ObjectOutputStream outputToChild = new ObjectOutputStream(System.out)) { // Use whatever output required by your callable
            inputFromParent = new ObjectInputStream(System.in); // Use input from parent process as an argument to Callable<T>
            x = (Callable<T>) inputFromParent.readObject(); // Invoke the Callable, with inputs and outputs handled externally via streams.
            T result = x.call();
            outputToChild.writeObject("YourMessageAfterExecution");
        } catch (IOException | ClassCastException | ClassNotFoundException | Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                inputFromParent.close(); // Make sure to close your resources appropriately!
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
    }
}