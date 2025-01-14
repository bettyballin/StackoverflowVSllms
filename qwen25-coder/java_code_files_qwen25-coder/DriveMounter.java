import java.lang.String;
public class DriveMounter {
    public static void main(String[] args) {
        // Define the drive letter and UNC path
        String driveLetter = "F:";
        String uncPath = "\\\\server\\share";

        try {
            // Execute the command line to map the network drive
            Process process = Runtime.getRuntime().exec("net use " + driveLetter + " " + uncPath + " /user:username password");

            // Wait for the command to complete
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Drive mounted successfully.");
            } else {
                System.err.println("Failed to mount drive. Exit code: " + exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}