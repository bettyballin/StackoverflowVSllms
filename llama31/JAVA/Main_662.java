import java.lang.String;
import jml.MsnMessenger;
import jml.MsnUser;

public class Main_662_662 {
    public static void main(String[] args) {
        try {
            MsnMessenger messenger = new MsnMessenger("your_email@hotmail.com", "your_password");
            messenger.login();

            MsnUser user = messenger.getContact("friend_email@hotmail.com");
            user.sendMessage("Hello, friend!");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}