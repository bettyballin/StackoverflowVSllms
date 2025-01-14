import java.lang.String;
import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int port = 12345;
        String filename = "sendingFile.txt";

        JProgressBar progressBar = new JProgressBar(0, (int)new File(filename).length());
        JFrame frame = new JFrame();
        frame.add(progressBar);
        frame.setSize(300, 80);
        frame.setVisible(true);

        try (Socket socket = new Socket(serverAddress, port);
             BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
             FileInputStream fis = new FileInputStream(filename)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            long totalBytesRead = 0;

            while ((bytesRead = fis.read(buffer)) > -1) {
                bos.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
                progressBar.setValue((int)totalBytesRead); // updating progress bar
            }

            System.out.println("File sent successfully with " + totalBytesRead + " bytes.");
        }
        
        frame.setVisible(false);
    }
}