/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class ProcessErrorHandler {
    public static void main(String[] stringArray) {
        ProcessBuilder processBuilder = new ProcessBuilder("your_command_here");
        try {
            Process process = processBuilder.start();
            int n = process.waitFor();
            if (n != 0) {
                System.out.println("Error occurred. Exit value: " + n);
            } else {
                System.out.println("Process executed successfully.");
            }
        }
        catch (IOException iOException) {
            System.out.println("An I/O error occurred.");
            iOException.printStackTrace();
        }
        catch (InterruptedException interruptedException) {
            System.out.println("The current thread was interrupted.");
            interruptedException.printStackTrace();
        }
    }
}
