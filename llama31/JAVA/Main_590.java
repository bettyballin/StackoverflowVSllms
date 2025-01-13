import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_590 {
    public static void main(String[] args) throws IOException {
        byte[] imageByteArr = new byte[0]; // initialize your byte array here
        File tempFile = File.createTempFile("temp", ".tmp");
        tempFile.deleteOnExit();
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(imageByteArr);
        }
        // assuming 'helper' is an object of a class that has the 'addInline' method
        // helper.addInline("cImage", new FileSystemResource(tempFile));
    }
}