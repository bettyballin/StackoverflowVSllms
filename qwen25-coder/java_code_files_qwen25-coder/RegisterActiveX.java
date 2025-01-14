import java.lang.String;
import java.io.IOException;

public class RegisterActiveX {
    public static void main(String[] args) {
        // Path to the DLL file you want to register
        String dllPath = "C:\\path\\to\\your\\activex.dll";

        // Use ProcessBuilder to execute regsvr32.exe with the /s switch to suppress messages
        ProcessBuilder processBuilder = new ProcessBuilder("regsvr32", "/s", dllPath);

        try {
            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to complete and get the exit value
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("ActiveX DLL registered successfully.");
            } else {
                System.err.println("Failed to register ActiveX DLL. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}