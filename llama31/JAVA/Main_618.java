import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main_618 {
    public static void main(String[] args) {
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect("ftp.example.com");
            ftp.login("username", "password");

            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            File file = new File("localfile.txt");
            FileInputStream fis = new FileInputStream(file);

            try {
                ftp.storeFile("remotefile.txt", fis);
                System.out.println("File uploaded successfully!");
            } catch (IOException e) {
                System.err.println("Error uploading file: " + e.getMessage());
            } finally {
                fis.close();
                ftp.disconnect();
            }
        } catch (IOException e) {
            System.err.println("Error connecting to FTP server: " + e.getMessage());
        }
    }
}