import java.lang.String;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

import java.net.MalformedURLException;
import java.io.IOException;

public class SmbExample {

    public static void main(String[] args) {
        try {
            // Replace with your domain, username, password and UNC path
            String domain = "WORKGROUP";
            String user = "user";
            String password = "password";
            String uncPath = "smb://server/share/folder/";

            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(domain, user, password);
            SmbFile smbFile = new SmbFile(uncPath, auth);

            if (smbFile.exists() && smbFile.isDirectory()) {
                for (SmbFile file : smbFile.listFiles()) {
                    System.out.println("Found file: " + file.getName());
                    // You can read from the file here using an inputStream
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}