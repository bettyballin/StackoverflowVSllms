public class RegistryKeyMigrator {
    // Before (requires admin privileges)
    String oldKeyPath = "HKEY_LOCAL_MACHINE\\Software\\YourApp";
    
    // After (accessible with standard user account)
    String newKeyPath = "HKEY_CURRENT_USER\\Software\\YourApp";
    
    public static void main(String[] args) {
    }
}