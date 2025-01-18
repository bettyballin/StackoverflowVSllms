import java.io.*;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

public class FileShareHandler {
    private String domain;
    private String userName;
    private String password;
    private NtlmPasswordAuthentication auth;

    public FileShareHandler(String domain, String username, String password) throws Exception {
        this.domain = domain;
        this.userName = username;
        this.password = password;
        auth = new NtlmPasswordAuthentication(domain, username, password);
    }

    public InputStream loadFileFromFileShare(String uncFilePath) {
        try {
            SmbFile smbFile = new SmbFile(uncFilePath, auth);
            return new SmbFileInputStream(smbFile);
        } catch (IOException ex) {
            throw new RuntimeException("Unable to find file: " + uncFilePath, ex);
        }
    }

    public void saveToFileshare(String uncFilePath, InputStream inputStream) {
        try {
            SmbFile smbFile = new SmbFile(uncFilePath, auth);
            try (SmbFileOutputStream smbOut = new SmbFileOutputStream(smbFile)) {
                byte[] buffer = new byte[8192];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    smbOut.write(buffer, 0, length);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Unable to write file: " + uncFilePath, ex);
        }
    }
}