import java.lang.String;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandler {

    private void writeContent(File file, String fileContent) {
        try (FileOutputStream to = new FileOutputStream(file)) {
            to.write(fileContent.getBytes());
            to.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteFile(File file) {
        if (file.exists() && file.canWrite()) {
            return file.delete();
        }
        return false;
    }

    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        File file = new File("example.txt");
        handler.writeContent(file, "Hello, world!");

        if (file.exists() && file.canRead() && file.canWrite()) {
            System.out.println("File can be read and written.");
            boolean isDeleted = handler.deleteFile(file);
            if (isDeleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        }
    }
}