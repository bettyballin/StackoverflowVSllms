import java.io.IOException;

public class ProcessErrorHandler {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("your_command_here"); // Replace "your_command_here" with the actual command you want to execute.
        try {
            Process process = processBuilder.start();
            int exitValue = process.waitFor();
            if (exitValue != 0) {
                // Handle error
                System.out.println("Error occurred. Exit value: " + exitValue);
            } else {
                System.out.println("Process executed successfully.");
            }
        } catch (IOException e) {
            System.out.println("An I/O error occurred.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("The current thread was interrupted.");
            e.printStackTrace();
        }
    }
}