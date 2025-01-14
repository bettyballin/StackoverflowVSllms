import java.util.ArrayList;
import java.util.List;

public class ImagePathGenerator {
    private static final String[] SIZES = {"large_", "medium_", "small_"};

    public List<String> generateImagePaths(String basePath) {
        List<String> paths = new ArrayList<>();
        // Add original path
        paths.add(basePath);
        
        for (String size : SIZES) {
            int dotIndex = basePath.lastIndexOf('.');
            String name = basePath.substring(0, dotIndex);
            String extension = basePath.substring(dotIndex);
            paths.add(size + name + extension);
        }
        
        return paths;
    }

    public static void main(String[] args) {
    }
}