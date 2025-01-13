import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TempDirExample_1_1 {
    public static void main(String[] args) throws IOException {
        File tempDir = FileUtils.getTempDirectory();
        File myTempDir = new File(tempDir, "myTempDir");
        myTempDir.mkdir();
        System.out.println(myTempDir);
        // Clean up when done
        myTempDir.deleteOnExit();
    }
}