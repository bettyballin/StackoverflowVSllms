import com.google.api.services.directory.Directory;
import com.google.api.services.directory.model.User;
import java.io.IOException;

public class GetUserClass {

    public User getUser(String userId, Directory adminService) throws IOException {
        return adminService.users().get(userId).execute();
    }
}