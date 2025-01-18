import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTP;

public class Example {
    public void uploadFile(String filename) throws Exception {
        File file = new File("path" + filename);
        FTPClient ftp = new FTPClient();
        try (InputStream in = new FileInputStream(file)) {
            ftp.connect("hostname"); // replace with your hostname or IP
            ftp.login("username", "password"); // replace with user, pass combination which have access to this path from where file is going to uploaded on FTP server
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            boolean done = ftp.storeFile("/" + filename, in); // use your path for folder instead of "/" if you are not uploading on root directory.
        } finally {
            ftp.disconnect();
        }
    }
}