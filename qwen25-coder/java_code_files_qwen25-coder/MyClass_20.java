public class MyClass {
    private static final Logger logger = new Logger();
    
    public void someMethod() {
        try {
            // code that might throw exception
        } catch (Exception e) {
            logger.error("An error occurred", e);
            logExtraDetails();
        }
    }
    
    private void logExtraDetails() {
        // Log additional information like method arguments, etc.
    }
    
    private static class Logger {
        public void error(String message, Exception e) {
            System.err.println(message);
            e.printStackTrace();
        }
    }
}