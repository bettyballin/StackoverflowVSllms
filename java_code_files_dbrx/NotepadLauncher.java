import java.lang.String;
import java.io.IOException;

public class NotepadLauncher {
    // Create an anonymous method to start Notepad in another process without showing a UI on Windows Vista
    public static void runNotepad() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "start", "/MIN", "notepad.exe");
        // Start the process with no window and wait for it to finish
        try {
            Process p = pb.start();
            int exitCode = p.waitFor();
            if (exitCode != 0) {
                throw new IOException("Notepad exited abnormally");
            }
        } catch (InterruptedException e) {
            // Handle the error here, or just print a stack trace
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    }
}