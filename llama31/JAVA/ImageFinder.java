import java.util.Arrays;
import java.util.List;

// Assuming Image is a custom class, you need to import or define it
// Assuming repository is an instance of a class with a findImagesWithTags method, you need to import or define it

public class ImageFinder {
    List<String> tags = Arrays.asList("a", "b", "c");
    int tagCount = 3;
    List<Image> images; // Declare images here

    public ImageFinder() {
        // Initialize images in the constructor
        // Assuming repository is defined and has a findImagesWithTags method
        images = repository.findImagesWithTags(tags, tagCount);
    }

    public static void main(String[] args) {
        new ImageFinder(); // Create an instance of ImageFinder
    }
}