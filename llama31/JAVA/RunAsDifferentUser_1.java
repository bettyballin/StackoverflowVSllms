import java.io.IOException;
import java.lang.String;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

public interface Advapi32 extends Library {
    Advapi32 INSTANCE = Native.load("advapi32", Advapi32.class);

    boolean LogonUser(String lpszUsername, String lpszDomain, String lpszPassword, int dwLogonType, int dwLogonProvider, PointerByReference phToken);
}

public class RunAsDifferentUser_1_1 {
    public static void main(String[] args) {
        String username = "differentUser";
        String password = "password";
        String command = "notepad.exe";

        Advapi32 advapi32 = Advapi32.INSTANCE;
        PointerByReference token = new PointerByReference();

        if (advapi32.LogonUser(username, null, password, 3, 0, token)) {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.environment().put("token", token.getValue().toString());

            try {
                Process process = processBuilder.start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } else {
            System.err.println("Error: Unable to logon user");
        }
    }
}