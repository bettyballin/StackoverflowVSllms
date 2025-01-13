import java.lang.String;

public class WindowsNetworkDriveMapper {
    public static void main(String[] args) {
        String driveLetter = "Z"; // replace with desired drive letter
        String uncPath = "\\server\\share"; // replace with desired UNC path
        String username = "username"; // replace with desired username
        String password = "password"; // replace with desired password

        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "net use " + driveLetter + ": " + uncPath + " /user:" + username + " " + password);
        try {
            pb.start();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}