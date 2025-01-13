import java.lang.String;

public class SomeDataCache_1_1 {
    private final Object lock = new Object();

    private SomeData[] getSomeDataByEmail(WebServiceInterface service, String email) {
        final String key = "Data-" + email;
        synchronized (lock) {
            // synchronized code here
        }
        return null; // Added return statement to make the code compile
    }

    public static void main(String[] args) {
    }
}

// Added the missing class definitions
class SomeData {}

interface WebServiceInterface {}