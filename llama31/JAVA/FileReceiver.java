import java.lang.String;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;

public class FileReceiver {
    private static final int PORT = 8000;

    public static void main(String[] args) throws Exception {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(PORT);

        // Accept incoming connections
        Socket socket = serverSocket.accept();

        // Get the file to receive
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save file");
        int returnVal = fileChooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Receive the file
            InputStream in = socket.getInputStream();
            FileOutputStream fileOut = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytesRead = 0;
            while ((bytesRead = in.read(buffer)) != -1) {
                fileOut.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;

                // Update progress bar
                int progress = (int) ((totalBytesRead / (float) file.length()) * 100);
                System.out.println("Receiving file... (" + progress + "%)");
            }
            fileOut.close();
            in.close();
        }

        // Close the socket
        socket.close();
        serverSocket.close();
    }
}