import java.lang.String;
import java.io.File;

public class OpenFileWithDefaultApplication {
    public static void main(String[] args) {
        File file = new File("path/to/your/file.jpg");
        
        // Determine the command based on OS
        String os = System.getProperty("os.name").toLowerCase();
        String[] cmd;
        
        if (os.contains("win")) {
            // Use ShellExecute to handle all file types correctly in Windows
            cmd = new String[]{"cmd", "/c", "start", "", file.getAbsolutePath()};
        } else if (os.contains("mac")) {
            // Open the file with the default application on Mac
            cmd = new String[]{"open", file.getAbsolutePath()};
        } else { 
            // Linux command to open a file with its associated application
            cmd = new String[]{"xdg-open", file.getAbsolutePath()};
        }
        
        try {
            Process process = new ProcessBuilder(cmd).start();
            int exitCode = process.waitFor(); // Wait for the process to finish
            System.out.println("The process exited with code " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}