import java.lang.String;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

public class Main_317_317 {
    public static void main(String[] args) throws Exception {
        String uncPath = "smb://username:password@server/share/path";
        SmbFile smbFile = new SmbFile(uncPath);
        
        // Read from the file
        SmbFileInputStream in = new SmbFileInputStream(smbFile);
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        while (bytesRead != -1) {
            System.out.write(buffer, 0, bytesRead);
            bytesRead = in.read(buffer);
        }
        in.close();
        
        // Write to the file
        SmbFileOutputStream out = new SmbFileOutputStream(smbFile);
        String content = "Hello, world!";
        out.write(content.getBytes());
        out.close();
    }
}