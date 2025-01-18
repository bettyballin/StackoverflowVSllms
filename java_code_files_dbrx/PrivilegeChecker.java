import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrivilegeChecker {
    boolean isRunningAsAdmin() {
        try {
            Process process = Runtime.getRuntime().exec("whoami /all");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Privileges: SeAssignPrimaryTokenPrivilege")) {
                    return true;
                }
            }
        } catch (IOException e) {
            // Handle exception
        }

        return false;
    }
    public static void main(String[] args) {
    }
}