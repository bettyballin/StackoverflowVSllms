public class MigrationPasswordEncoderUpdater {

    public void loginAttempt(String username, String providedPassword) {
        User user = getUserFromDatabase(username);
        if (user == null) {
            // handle error - no such user
            return;
        }

        boolean isMigrated = false; // Assume this value comes from a field in your database

        if (!isMigrated) {
            // Check plaintext password against unsalted hash
            String existingHash = user.getUnsaltedHash();
            if (PasswordUtils.checkPassword(providedPassword, "$2a$10$" + existingHash)) { 
                // Assuming existingHash was originally a 10 char long hash for example purposes
                
                // Re-hash the password with a salt
                String newSaltedHash = PasswordUtils.hashPassword(providedPassword);
                
                // Update user in database to use the new salted hash
                updateUserDatabaseWithNewHash(user.getId(), newSaltedHash, true); // second parameter is the flag to mark as migrated
                
                System.out.println("User password has been migrated to a new salted hash.");
            } else {
                // Incorrect password
                return;
            }
        } else {
            // Check with the existing salted hash directly
            String existingSaltedHash = user.getSaltedHash();
            if (PasswordUtils.checkPassword(providedPassword, existingSaltedHash)) {
                System.out.println("User logged in successfully.");
            } else {
                // Incorrect password
                return;
            }
        }
    }
    
    public User getUserFromDatabase(String username) {
        // Placeholder implementation
        return new User();
    }
    
    public void updateUserDatabaseWithNewHash(int userId, String newHash, boolean migrated) {
        // Placeholder implementation
    }
    
    public static void main(String[] args) {
        MigrationPasswordEncoderUpdater updater = new MigrationPasswordEncoderUpdater();
        updater.loginAttempt("user1", "password123");
    }
}

class User {
    public String getUnsaltedHash() {
        return "existingHash";
    }

    public String getSaltedHash() {
        return "existingSaltedHash";
    }

    public int getId() {
        return 1;
    }
}

class PasswordUtils {
    public static boolean checkPassword(String providedPassword, String hash) {
        // Placeholder implementation
        return true;
    }

    public static String hashPassword(String password) {
        // Placeholder implementation
        return "newSaltedHash";
    }
}