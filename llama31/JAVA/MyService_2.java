import javax.transaction.Transactional;
import javax.persistence.FlushModeType;

// Assuming @Service is not crucial for compilation and execution in this context,
// it is removed as it typically requires Spring Framework context to be meaningful.

public class MyService_2_2 {

    @Transactional
    public void readOnlyOperation() {
        // perform read-only operations here
    }

    public static void main(String[] args) {
        // Added a simple instantiation to demonstrate it can be compiled and run.
        MyService_2 myService = new MyService_2();
        myService.readOnlyOperation();
    }
}