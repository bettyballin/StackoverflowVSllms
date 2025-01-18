import java.lang.String;
import java.io.*;
public class DirectoryPermissionChecker {
    public static boolean canWriteInDirectory(String path) {
        File testFile = new File(path + "/test-" + System.nanoTime());
        try {
            testFile.createNewFile();//Create a temporary file
            testFile.deleteOnExit();//Delete when application exits or do it after checking write capabilities
            return true;
        } catch (IOException e) {
            //System.out.println("Unable to check directory permissions");
           /* handle exception here based on your requirement */
        }
       return false;
    }

	public static void main(String[] args) {
	}
}