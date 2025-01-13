import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter_2_2 {
    private void writeContent(File file, String fileContent) {
        FileOutputStream to;
        try {
            to = new FileOutputStream(file);
            to.write(fileContent.getBytes());
            to.getFD().sync();
            to.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create an instance of the class to call the non-static method
        FileWriter_2 writer = new FileWriter_2();
        // Example usage:
        // writer.writeContent(new File("example.txt"), "Hello, World!");
    }
}