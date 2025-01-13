/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class Main_450 {
    public static void main(String[] stringArray) {
        try {
            Process process = Runtime.getRuntime().exec("taskkill /PID 1234 /F");
            int n = process.waitFor();
            if (n != 0) {
                System.out.println("Error executing command: " + n);
            }
        }
        catch (IOException iOException) {
            System.out.println("Error executing command: " + iOException.getMessage());
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}
