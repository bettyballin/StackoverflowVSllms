import java.util.*;

public class EmailSynchronizer {
    public static void main(String[] args) {
        // Assuming 'user', 'form', and 'db' are defined elsewhere in the code
        String user = "exampleUser";
        Form form = new Form(); // Replace with actual Form class
        DB db = new DB(); // Replace with actual DB class

        // Get the list of emails from the DB
        List<String> emailsInDB = getAllMailsFromDB(user);

        // Get the list of emails from the form
        List<String> emailsInForm = form.getAllMails();

        // Create a set of emails from the form for efficient lookups
        Set<String> emailSet = new HashSet<>(emailsInForm);

        // Delete emails that are in the DB but not in the form
        for (String email : emailsInDB) {
            if (!emailSet.contains(email)) {
                db.deleteMail(email);
            }
        }

        // Insert or update emails that are in the form
        for (String email : emailsInForm) {
            if (!emailsInDB.contains(email)) {
                db.insertMail(email, user);
            }
        }
    }

    // Assuming this method is defined elsewhere in the code
    public static List<String> getAllMailsFromDB(String user) {
        // Replace with actual implementation
        return new ArrayList<>();
    }
}

// Assuming Form and DB classes are defined elsewhere in the code
class Form {
    public List<String> getAllMails() {
        // Replace with actual implementation
        return new ArrayList<>();
    }
}

class DB {
    public void deleteMail(String email) {
        // Replace with actual implementation
    }

    public void insertMail(String email, String user) {
        // Replace with actual implementation
    }
}