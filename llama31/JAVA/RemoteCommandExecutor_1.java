import org.apache.winrm4j.client.WinRmClient;
import org.apache.winrm4j.client.WinRmClientContext;
import org.apache.winrm4j.client.WinRmException;

public class RemoteCommandExecutor_1_1 {
    public static void main(String[] args) {
        String hostname = "your_windows_server_hostname";
        String username = "your_username";
        String password = "your_password";
        String command = "dir";

        WinRmClient client = new WinRmClient(hostname, username, password);
        WinRmClientContext context = client.createContext();

        try {
            String output = context.executeCommand(command);
            System.out.println(output);
        } catch (WinRmException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            context.close();
        }
    }
}