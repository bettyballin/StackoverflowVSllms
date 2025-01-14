public class EmailService {
    public String handleSignup(String email) {
        if (isEmailRegistered(email)) {
            sendGenericConfirmationEmail(email);
            return "Thank you for your interest! If you have an account with us, instructions to reset your password will be sent shortly.";
        }
        
        // Proceed with new user registration process
        return "Registration successful!";
    }

    public String handleChangeEmailRequest(User user, String newEmail) {
        if (isEmailRegistered(newEmail)) {
            return "We could not change the email address. Please try again later.";
        }

        sendVerificationEmail(user, newEmail);
        return "A confirmation request has been sent to your provided email address";
    }

    private void sendGenericConfirmationEmail(String email) {
        // Send a generic email without revealing if the account exists
    }

    private void sendVerificationEmail(User user, String newEmail) {
        // Send an email with verification code/link
    }

    private boolean isEmailRegistered(String email) {
        // Check database to see if email is registered
        return false;  // pseudo-implementation
    }

    public static void main(String[] args) {
    }
}

class User {
    // User class implementation
}