import java.io.FileInputStream;
import java.io.InputStream;

public class ResourceLoader {
    public static void main(String[] args) {
        ResourceLoader loader = new ResourceLoader();
        loader.loadResource();
    }

    public void loadResource() {
        String file = "map.mp";
        InputStream is = this.getClass().getResourceAsStream(file);
        if (is != null) {
            // file found, read it
            // Note: You can't directly create a FileInputStream from an InputStream.
            // FileInputStream is used to read from a file, while InputStream is a more general class.
            // If you want to read from the InputStream, you can use it directly.
            // Here, I'm just printing a message to indicate that the file was found.
            System.out.println("File found");
        } else {
            // file not found
            System.out.println("File not found");
        }
    }
}