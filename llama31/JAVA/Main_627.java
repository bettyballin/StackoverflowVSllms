public class Main_627 {
    public static void main(String[] args) {
        String emailContent = "Your email content here.\r\n";
        // ...
        emailContent = emailContent.replace("\n", "\r\n"); // Ensure CRLF line endings
        // Send the email using your preferred method
        System.out.println(emailContent);
    }
}