import org.apache.commons.net.ftp.FTPClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FtpUploadExample {
    public static void main(String[] args) {
        String server = "ftp.example.com";
        int port = 21;
        String user = "username";
        String pass = "password";

        FTPClient ftpClient = new FTPClient();
        try (FileInputStream fis = new FileInputStream(new File("file_to_upload.txt"))) {

            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            System.out.println(ftpClient.getStatus());

            boolean done = ftpClient.storeFile("file_on_server.txt", fis);
            if (done) {
                System.out.println("The file is uploaded successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}