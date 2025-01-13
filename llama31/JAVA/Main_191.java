import java.util.UUID;

public class Main_191 {
    public static String getUniqueFileName(String directory, String extension) {
        return directory + UUID.randomUUID().toString() + extension;
    }

    public static void main(String[] args) {
        System.out.println(getUniqueFileName("/path/to/directory/", ".txt"));
    }
}