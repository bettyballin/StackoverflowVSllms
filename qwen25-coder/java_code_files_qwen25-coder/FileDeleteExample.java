import java.lang.String;
import java.io.File;

public class FileDeleteExample {
    public static void main(String[] args) {
        File file = new File("nonExistentFile.txt");
        boolean isDeleted = file.delete();
        System.out.println("Was the file deleted? " + isDeleted);
    }
}