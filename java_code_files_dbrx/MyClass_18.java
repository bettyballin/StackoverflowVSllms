public class MyClass {

    private boolean shouldRun;

    private void doSendData() {
        // Infinite Loop with a condition based on 'shouldRun' flag
        while (shouldRun) {
            try {
                // Code to send data goes here
            } catch (Exception e) {
                // Handle exception
            }
            // Additional code
        }
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.shouldRun = true; // Set the condition to start the loop
        obj.doSendData();
    }
}