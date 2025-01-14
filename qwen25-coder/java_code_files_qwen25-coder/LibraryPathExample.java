import java.lang.String;
import java.io.File;

public class LibraryPathExample {
    public static void main(String[] args) {
        // Get the user's home directory
        String userHome = System.getProperty("user.home");
        
        // Construct the path to the Application Support directory for your app
        File appSupportDir = new File(userHome, "Library/Application Support/Your App Name");
        
        // Create the directory if it doesn't exist
        if (!appSupportDir.exists()) {
            boolean mkdirsSuccess = appSupportDir.mkdirs();
            if (mkdirsSuccess) {
                System.out.println("Directory created successfully.");
            } else {
                System.out.println("Failed to create directory.");
            }
        }
        
        // Print the path
        System.out.println("Application Support Directory: " + appSupportDir.getAbsolutePath());
    }
}