import com.google.gdata.client.appsforyourdomain.AppsForYourDomainService;
import com.google.gdata.data.appsforyourdomain.UserEntry;

public class Main_371 {
    public static void main(String[] args) {
        // Create a new AppsForYourDomainService object
        AppsForYourDomainService service = new AppsForYourDomainService("your-domain", "your-admin-username", "your-admin-password");

        // Retrieve the user entry
        UserEntry user = service.retrieveUser("username");

        // Disable password updates for the user
        user.setCanChangePassword(false);

        // Update the user entry
        service.updateUser(user);
    }
}