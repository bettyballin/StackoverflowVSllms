import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserProfileImageManager {

    private static final String IMAGE_DIR = "user_images/";

    public void saveUserImage(String userId, byte[] imageData) throws Exception {
        Path imagePath = Paths.get(IMAGE_DIR + userId + ".png");
        Files.write(imagePath, imageData);
    }

    public byte[] getUserImage(String userId) throws Exception {
        Path imagePath = Paths.get(IMAGE_DIR + userId + ".png");
        return Files.readAllBytes(imagePath);
    }

	public static void main(String[] args) {
	}
}