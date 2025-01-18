import java.lang.String;

public class MySingleton {
    private static volatile MySingleton instance = null;     // The one and only instance of this singleton
    public boolean typeInitialisedSuccessfully = false;      // Flag to track initialization status
    private MySingleton() {}                                 // Private constructor prevents instantiation from outside

    /** SingletonHolder is loaded on the first execution of Singleton.getInstance() */
    private static class SingletonHolder {
        private static final MySingleton INSTANCE = new MySingleton();
    }

    public static void initializeData() throws Exception {   // Your initialization method, which can throw an exception
        try {                                                // Try something dangerous
            // Code that might cause an unrecoverable error here…

            // Obtain the singleton instance
            MySingleton instance = getInstance();
            instance.typeInitialisedSuccessfully = true;     // Only set this flag after all processing!

        } catch (Exception ex) {                             // Oops, we failed – re-throw as needed
            // Maybe do some logging or cleanup work before failure?
            throw new Exception("Failed to initialize data", ex); // Pass in original exception for context
        }
    }

    /** Thread-safe singleton instantiation: the constructor will be executed only once */
    public static MySingleton getInstance() {
        return SingletonHolder.INSTANCE;                     // Retrieve our shared instance via lazy loading
     }

     public static void main(String[] args) {
         // Test code
     }
}