import java.util.UUID;

public class FileNameGenerator {

    public String getUniqueFileName(String directory, String extension) {
        // Generate a UUID
        String uuid = UUID.randomUUID().toString();
        
        // Format the file name with the specified directory and extension
        return directory + "/" + uuid + "." + extension;
    }
}