public class ShutdownHookThread {
    static Process p; // where 'p' is your Process instance that you want to destroy.

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (p != null) {
                    p.destroy(); // where 'p' is your Process instance that you want to destroy.
                }
            }
        });
        // Your application code here
        // Assign 'p' to the Process instance you want to destroy.
    }
}