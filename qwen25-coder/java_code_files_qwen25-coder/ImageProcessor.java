import java.io.IOException;

public class ImageProcessor {
    private final String imagePath;
    private final int width;
    private final int height;

    public ImageProcessor(String imagePath, int width, int height) {
        this.imagePath = imagePath;
        this.width = width;
        this.height = height;
    }

    public Thumbnail generateThumbnail() throws IOException {
        // Logic to create a thumbnail
        /* ... */
        return new Thumbnail("src_placeholder", width, height);
    }
}

class Thumbnail {
    private final String src;
    private final int width;
    private final int height;

    public Thumbnail(String src, int width, int height) {
        this.src = src;
        this.width = width;
        this.height = height;
    }

    // Getters

    public static void main(String[] args) {
    }
}