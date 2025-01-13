import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;

import oracle.sql.BFILE;

public class Main_114 {
    public static void main(String[] args) throws Exception {
        // Replace "..." with your actual BFILE object
        BFILE bfile = new BFILE(); // You need to initialize the BFILE object properly
        InputStream in = bfile.getBinaryStream();

        // Replace "file" with your actual file path
        File file = new File("path_to_your_file");

        // write the file contents to disk
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}