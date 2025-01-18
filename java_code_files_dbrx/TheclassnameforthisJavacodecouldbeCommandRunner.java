import java.io.*;
import java.util.Arrays;

public class TheclassnameforthisJavacodecouldbeCommandRunner {

    public String runAsUser(String username, String command, String userPassword) {

        ProcessBuilder builder = new ProcessBuilder("runas", "/user:" + username, command);
        builder.redirectErrorStream(true);  // Redirect error streams to standard output

        try {
            final Process process = builder.start();

            InputStream stdoutInputStream = process.getInputStream();
            OutputStream stdinOutputStream = process.getOutputStream();

            Thread inputThread = new Thread(() -> {
                try (PrintWriter writer = new PrintWriter(stdinOutputStream)) {
                    writer.println(userPassword); // Write password to stdin
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            inputThread.start(); // Start the thread to write password

            byte[] buffer = new byte[4096];
            int n;
            String result = "";
            while ((n = stdoutInputStream.read(buffer)) != -1) {
                result += new String(Arrays.copyOfRange(buffer, 0, n));
            }

            process.waitFor();

            if (process.exitValue() == 0)
                return result; // No error occurred during execution

        } catch (IOException | InterruptedException e) {
            System.err.println("Error while trying to run command with user " + username);
        }
        return null; // Return null if an error occurred
    }

    public static void main(String[] args) {
        TheclassnameforthisJavacodecouldbeCommandRunner runner = new TheclassnameforthisJavacodecouldbeCommandRunner();
        String username = "username"; // Replace with actual username
        String command = "command";   // Replace with actual command
        String userPassword = "my-password"; // Replace with actual password

        String result = runner.runAsUser(username, command, userPassword);
        if (result != null) {
            System.out.println("Command output:");
            System.out.println(result);
        }
    }
}