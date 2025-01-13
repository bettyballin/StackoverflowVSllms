import java.lang.String;

public class FileNameGenerator {
    public String getUniqueFileName(String directory, String extension) {
        return directory + System.currentTimeMillis() + "_" + Math.random() + extension;
    }

    public static void main(String[] args) {
        FileNameGenerator generator = new FileNameGenerator();
        System.out.println(generator.getUniqueFileName("/path/to/directory/", ".txt"));
    }
}