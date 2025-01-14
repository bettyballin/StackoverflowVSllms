import java.lang.String;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.vfs2.*;

public class FtpTest {
    public void testFtpOperations() throws Exception {
        FileSystemManager fsManager = VFS.getManager();
        FileObject remoteFile = fsManager.resolveFile("ftp://user:password@ftp.example.com/remote-file.txt");
        FileContent content = remoteFile.getContent();

        // Example of writing to FTP
        OutputStream os = content.getOutputStream();
        os.write("Test data".getBytes());
        os.close();

        // Example of reading from FTP
        InputStream is = content.getInputStream();
        byte[] buffer = new byte[1024];
        int readBytes;
        while ((readBytes = is.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, readBytes));
        }
        is.close();
    }

    public static void main(String[] args) {
    }
}