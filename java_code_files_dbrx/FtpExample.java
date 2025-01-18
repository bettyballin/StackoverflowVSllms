import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FtpExample {
    public static void main(String[] args) throws Exception {
        String server = "example.com";
        int port = 21;
        String user = "username";
        String pass = "password";

        FTPClient ftpClient = new FTPClient();
        try {
            // Connect and login to the FTP server
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);

            // Use passive mode for firewall/NAT issues or active mode which is default
            ftpClient.enterLocalPassiveMode();
            // or use enterLocalActiveMode() for active mode

            File firstLocalFile = new File("foo.txt");
            String firstRemoteFile = "foo.txt";
            InputStream inputStream = new FileInputStream(firstLocalFile);

            System.out.println("Start uploading first file: " + firstRemoteFile);

            // Open an OutputStream to the remote file
            OutputStream outputStream = ftpClient.storeFileStream(firstRemoteFile);
            if (outputStream == null) {
                throw new IOException("Unable to open output stream to FTP server");
            }

            long progress = 0;
            int read = -1;
            byte[] buffer = new byte[5 * 1024]; // Adjust as necessary
            while ((read = inputStream.read(buffer)) > 0 ) {
                outputStream.write(buffer, 0, read);
                progress += read;
                System.out.printf("Progress: %02d%%\n", (progress * 100 / firstLocalFile.length()));
            }

            inputStream.close();
            outputStream.close();

            boolean completed = ftpClient.completePendingCommand();
            if (completed) {
                System.out.println("Upload complete.");
            } else {
                System.out.println("Unsuccessful upload.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}