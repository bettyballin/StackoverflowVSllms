import java.lang.String;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;

public class FileSender {
    private static final int PORT = 8000;

    public static void main(String[] args) throws Exception {
        // Create a socket
        Socket socket = new Socket("localhost", PORT);

        // Get the file to send
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Send the file
            OutputStream out = socket.getOutputStream();
            FileInputStream fileIn = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytesRead = 0;
            long fileSize = file.length();
            while ((bytesRead = fileIn.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;

                // Update progress bar
                int progress = (int) ((totalBytesRead / (float) fileSize) * 100);
                System.out.println("Sending file... (" + progress + "%)");
            }
            fileIn.close();
            out.close();
        }

        // Close the socket
        socket.close();
    }
}