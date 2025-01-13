import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class Main_405 {
    public static void main(String[] args) throws Exception {
        URL url = Main.class.getResource("myTemplate.dot");
        try (InputStream in = url.openStream()) {
            File tmpFile = File.createTempFile("myTemplate", ".dot");
            try (OutputStream out = new FileOutputStream(tmpFile)) {
                IOUtils.copy(in, out);
            }
            String absolutePath = tmpFile.getAbsolutePath();
            // Pass the absolutePath to MS Word to be opened as a document
            System.out.println(absolutePath);
        }
    }
}