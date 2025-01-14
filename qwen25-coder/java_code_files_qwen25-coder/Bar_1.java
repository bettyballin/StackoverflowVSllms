import java.lang.String;
// Bar.java
public class Bar {
    public static void main(String[] args) throws InterruptedException {
        // Obtain reference to SharedObject, which might be done through other means (e.g., singleton pattern)
        SharedObject shared = SharedObject.getInstance(); // Assuming getInstance method returns the shared object

        // Logic to check license and terminate thread here
        if (!isLicenseValid()) {
            System.out.println("License not valid. Terminating Thread.");
            shared.setShouldTerminate(true);
        }
    }

    private static boolean isLicenseValid() {
        // License validation logic
        return false;
    }
}

class SharedObject {
    private static SharedObject instance = new SharedObject();
    private boolean shouldTerminate;

    private SharedObject() {
    }

    public static SharedObject getInstance() {
        return instance;
    }

    public void setShouldTerminate(boolean value) {
        shouldTerminate = value;
    }

    public boolean getShouldTerminate() {
        return shouldTerminate;
    }
}