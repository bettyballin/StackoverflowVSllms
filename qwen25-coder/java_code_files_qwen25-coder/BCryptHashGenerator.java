import org.mindrot.jbcrypt.BCrypt;

public class BCryptHashGenerator {
    public static void main(String[] args) {
        // Generates a salt and computes the hash of the password including the salt
        String plain_password = "myPassword";
        String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());

        // When checking a candidate password, bcrypt extracts the salt from stored_hash and uses
        // it to hash the candidate_password for comparison.
        String candidate_password = "myPassword";
        String stored_hash = pw_hash;

        if (BCrypt.checkpw(candidate_password, stored_hash))
            System.out.println("It matches");
        else
            System.out.println("It does not match");
    }
}