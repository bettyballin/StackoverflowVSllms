import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.util.StrutsCoreConstants;
import org.apache.struts2.util.PasswordEncryptor;
import org.apache.struts2.util.BCryptPasswordEncryptor;

// Example of password encryption using Struts BCryptPasswordEncryptor
public class MyAction_7_7 extends ActionSupport {
    private String password;

    @Override
    public String execute() {
        PasswordEncryptor encryptor = new BCryptPasswordEncryptor();
        String encryptedPassword = encryptor.encrypt(password);
        // ...
        return SUCCESS;
    }

    public static void main(String[] args) {
        MyAction_7 action = new MyAction_7();
        action.execute();
    }
}