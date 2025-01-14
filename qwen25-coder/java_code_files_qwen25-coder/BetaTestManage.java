import java.lang.String;
// Example of using UserTesting API for management
import com.usertesting.api.*;

public class BetaTestManage {
    public static void main(String[] args) throws Exception {
        Client client = new Client("YOUR_API_KEY");
        Test test = client.getTestById(12345);
        System.out.println("Test Title: " + test.getTitle());
    }
}