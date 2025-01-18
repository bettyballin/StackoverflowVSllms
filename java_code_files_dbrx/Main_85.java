import java.io.File;

public class Main {
    public static void main(String[] args) {
        String absoluteUrl = new File("path/from_root/yourfile").toURI().toString();
        System.out.println("Absolute URL: " + absoluteUrl);
    }
}