import java.lang.String;
class SecureThread extends Thread {
    private String threadName;

    public SecureThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        try {
            // Custom security check based on thread name or any other condition
            if ("specialThread".equals(threadName)) {
                System.out.println("Special Thread performing sensitive operations...");
                performSensitiveOperation();
            } else {
                System.out.println("Regular Thread perform normal operations...");
                performNormalOperation();
            }
        } catch (SecurityException e) {
            System.err.println("Access denied: " + e.getMessage());
        }
    }

    private void performSensitiveOperation() {
        // Code for sensitive operation
        System.out.println("Performing sensitive operation.");
        // Ensure this thread has permission to perform this action
    }

    private void performNormalOperation() {
        // Code for normal operation
        System.out.println("Performing normal operation.");
    }
}

public class Main_105 {
    public static void main(String[] args) {
        Thread specialThread = new SecureThread("specialThread");
        Thread regularThread = new SecureThread("regularThread");

        specialThread.start();
        regularThread.start();
    }
}